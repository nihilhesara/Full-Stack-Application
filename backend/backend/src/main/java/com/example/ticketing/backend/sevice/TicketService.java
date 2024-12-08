package com.example.ticketing.backend.sevice;

import com.example.ticketing.backend.model.Ticket;
import com.example.ticketing.backend.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

}
