package com.example.ticketing.backend.controller;

import com.example.ticketing.backend.DTO.TicketDTO;
import com.example.ticketing.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:3000") // REMOVE THIS LINE (handled by CorsConfig)
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitTicketDetails(@RequestBody TicketDTO ticketDTO) {
        String response = ticketService.submitTicketDetails(ticketDTO);
        System.out.println("Received Ticket Details: " + ticketDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/start")
    public ResponseEntity<String> startBackend() {
        String response = ticketService.startBackend();
        System.out.println("Backend Start Requested");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopBackend() {
        String response = ticketService.stopBackend();
        System.out.println("Backend Stop Requested");
        return ResponseEntity.ok(response);
    }
}