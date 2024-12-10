package com.example.ticketing.backend.repository;

import com.example.ticketing.backend.model.TicketDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDetailsRepository extends JpaRepository<TicketDetails, Long> {
}
