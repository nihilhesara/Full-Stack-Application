package com.example.ticketing.backend.controller;

import com.example.ticketing.backend.DTO.TicketDTO;
import com.example.ticketing.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This controller handles HTTP requests related to ticket operations,
 * such as submitting ticket details, starting the backend, and stopping the backend.
 */
@RestController
@RequestMapping("/api")
public class TicketController {

    // Injecting the TicketService to handle business logic related to tickets
    @Autowired
    private TicketService ticketService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitTicketDetails(@RequestBody TicketDTO ticketDTO) {
        // Call the service to handle ticket submission
        String response = ticketService.submitTicketDetails(ticketDTO);
        // Log the received ticket details for debugging
        System.out.println("Received Ticket Details: " + ticketDTO);
        // Return an HTTP 200 response with the service's response message
        return ResponseEntity.ok(response);
    }

    @PostMapping("/start")
    public ResponseEntity<String> startBackend() {
        // Call the service to start the backend
        String response = ticketService.startBackend();
        // Log the backend start request for debugging
        System.out.println("Backend Start Requested");
        // Return an HTTP 200 response with the service's response message
        return ResponseEntity.ok(response);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopBackend() {
        // Call the service to stop the backend
        String response = ticketService.stopBackend();
        // Log the backend stop request for debugging
        System.out.println("Backend Stop Requested");
        // Return an HTTP 200 response with the service's response message
        return ResponseEntity.ok(response);
    }
}
