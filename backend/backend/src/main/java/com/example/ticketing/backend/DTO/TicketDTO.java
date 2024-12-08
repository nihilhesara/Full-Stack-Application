package com.example.ticketing.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TicketDTO implements Serializable {
    private  int totalNoTickets;
    private  int ticketReleaseRate;
    private  int customerRetrievalRate;
    private  int maximumTicketCapacity;
}

