package com.example.ticketing.backend.controller;

import com.example.ticketing.backend.model.Ticket;
import com.example.ticketing.backend.sevice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @PostMapping("/add-ticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Ticket savedTicket = ticketService.addTicket(ticket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }
}

