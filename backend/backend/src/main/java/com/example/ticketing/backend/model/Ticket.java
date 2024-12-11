package com.example.ticketing.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * This class represents a Ticket entity in the ticketing system.
 * It is annotated with @Entity to indicate that it is a JPA entity.
 */
@Entity
public class Ticket {

    // The unique identifier for the Ticket, generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The details of the Ticket, mapped to the "details" JSON property
    @JsonProperty("details")
    private String details;

    // The sold status of the Ticket, mapped to the "sold" JSON property
    @JsonProperty("sold")
    private boolean sold;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
