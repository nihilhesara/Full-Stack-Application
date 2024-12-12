package com.example.ticketing.backend.service;

import com.example.ticketing.backend.DTO.TicketDTO;
import com.example.ticketing.backend.model.Customer;
import com.example.ticketing.backend.model.Ticket;
import com.example.ticketing.backend.model.TicketDetails;
import com.example.ticketing.backend.model.Vendor;
import com.example.ticketing.backend.repository.CustomerRepository;
import com.example.ticketing.backend.repository.TicketDetailsRepository;
import com.example.ticketing.backend.repository.TicketRepository;
import com.example.ticketing.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * This service class contains the business logic for managing tickets,
 * including submitting ticket details, starting the backend, and stopping the backend.
 */
@Service
public class TicketService {

    // Autowired repositories to interact with the database
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketDetailsRepository ticketDetailsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VendorRepository vendorRepository;

    // Scheduler to manage periodic tasks
    private ScheduledExecutorService scheduler;

    public String submitTicketDetails(TicketDTO ticketDTO) {
        // Create and save TicketDetails entity
        TicketDetails ticketDetails = new TicketDetails();
        ticketDetails.setTotalTickets(ticketDTO.getTotalNoTickets());
        ticketDetails.setTicketReleaseRate(ticketDTO.getTicketReleaseRate());
        ticketDetails.setCustomerRetrievalRate(ticketDTO.getCustomerRetrievalRate());
        ticketDetails.setMaximumTicketCapacity(ticketDTO.getMaximumTicketCapacity());

        ticketDetailsRepository.save(ticketDetails);

        int totalNoTickets = ticketDTO.getTotalNoTickets();
        int ticketReleaseRate = ticketDTO.getTicketReleaseRate();

        // Create and save each ticket with a delay based on the ticket release rate
        for (int i = 0; i < totalNoTickets; i++) {
            Ticket ticket = new Ticket();
            ticket.setDetails("Ticket " + (i + 1));
            ticket.setSold(false);
            ticketRepository.save(ticket);
            try {
                Thread.sleep(1000 / ticketReleaseRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Ticket details submitted successfully.";
    }

    public String startBackend() {
        if (scheduler == null || scheduler.isShutdown()) {
            scheduler = Executors.newScheduledThreadPool(4);
            List<Customer> customers = customerRepository.findAll();
            List<Vendor> vendors = vendorRepository.findAll();

            // Schedule tasks for vendors to add new tickets
            vendors.forEach(vendor -> scheduler.scheduleAtFixedRate(() -> {
                Ticket ticket = new Ticket();
                ticket.setDetails("New Ticket from Vendor " + vendor.getName());
                ticket.setSold(false);
                ticketRepository.save(ticket);
                System.out.println("Vendor " + vendor.getName() + " added a ticket.");
            }, 0, 1, TimeUnit.SECONDS));

            // Schedule tasks for customers to buy tickets
            customers.forEach(customer -> scheduler.scheduleAtFixedRate(() -> {
                Optional<Ticket> optionalTicket = ticketRepository.findAll()
                        .stream()
                        .filter(ticket -> !ticket.isSold())
                        .findFirst();
                if (optionalTicket.isPresent()) {
                    Ticket ticket = optionalTicket.get();
                    ticket.setSold(true);
                    ticketRepository.save(ticket);
                    System.out.println("Customer bought a ticket.");
                }
            }, 0, 1, TimeUnit.SECONDS));
        }

        return "Backend started successfully.";
    }

    public String stopBackend() {
        if (scheduler != null && !scheduler.isShutdown()) {
            scheduler.shutdown();
            try {
                scheduler.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Backend stopped successfully.";
    }
}
