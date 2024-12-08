package com.example.ticketing.backend.repository;

import com.example.ticketing.backend.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {}

