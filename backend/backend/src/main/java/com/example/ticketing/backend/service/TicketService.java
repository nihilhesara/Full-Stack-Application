package com.example.ticketing.backend.service;

import com.example.ticketing.backend.DTO.TicketDTO;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public String startBackend() {
        // Logic to start backend processes
        System.out.println("Backend started successfully!");
        return "Backend started successfully!";
    }

    public String stopBackend() {
        // Logic to stop backend processes
        System.out.println("Backend stopped successfully!");
        return "Backend stopped successfully!";
    }

    public String submitTicketDetails(TicketDTO ticketDTO) {
        // Process the ticket details here
        System.out.println(ticketDTO);
        return "Ticket details submitted successfully!";
    }
}
