package com.example.ticketing.backend.config;

import com.example.ticketing.backend.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@Autowired
//private SimpMessagingTemplate messagingTemplate;
//
//@PostMapping
//public Ticket createTicket(@RequestBody Ticket ticket) {
//    Ticket createdTicket = ticketService.saveTicket(ticket);
//    messagingTemplate.convertAndSend("/topic/tickets", createdTicket);
//    return createdTicket;
//}
