package com.example.ticketing.backend.controller;

import com.example.ticketing.backend.DTO.TicketDTO;
import com.example.ticketing.backend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitTicketDetails(@RequestBody TicketDTO ticketDTO) {
        String response = ticketService.submitTicketDetails(ticketDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/start")
    public ResponseEntity<String> startBackend() {
        String response = ticketService.startBackend();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopBackend() {
        String response = ticketService.stopBackend();
        return ResponseEntity.ok(response);
    }
}
