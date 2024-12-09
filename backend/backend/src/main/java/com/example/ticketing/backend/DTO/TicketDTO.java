package com.example.ticketing.backend.DTO;

public class TicketDTO {

    private int totalNoTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maximumTicketCapacity;

    // Getters and setters

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