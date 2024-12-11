package com.example.ticketing.backend.DTO;

/**
 * Data Transfer Object (DTO) for transferring ticket-related data.
 * This class contains fields and methods to represent ticket details
 * such as total number of tickets, ticket release rate, customer retrieval rate,
 * and maximum ticket capacity.
 */
public class TicketDTO {

    // The total number of tickets available
    private int totalNoTickets;

    // The rate at which tickets are released
    private int ticketReleaseRate;

    // The rate at which customers retrieve tickets
    private int customerRetrievalRate;

    // The maximum capacity of tickets that can be held
    private int maximumTicketCapacity;

    // Getters and setters for each field

    public int getTotalNoTickets() {
        return totalNoTickets;
    }

    public void setTotalNoTickets(int totalNoTickets) {
        this.totalNoTickets = totalNoTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaximumTicketCapacity() {
        return maximumTicketCapacity;
    }

    public void setMaximumTicketCapacity(int maximumTicketCapacity) {
        this.maximumTicketCapacity = maximumTicketCapacity;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "totalNoTickets=" + totalNoTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maximumTicketCapacity=" + maximumTicketCapacity +
                '}';
    }
}
