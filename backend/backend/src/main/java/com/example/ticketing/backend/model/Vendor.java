package com.example.ticketing.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * This class represents a Vendor entity in the ticketing system.
 * It is annotated with @Entity to indicate that it is a JPA entity.
 */
@Entity
public class Vendor {

    // The unique identifier for the Vendor, generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The name of the Vendor, mapped to the "name" JSON property
    @JsonProperty("name")
    private String name;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
