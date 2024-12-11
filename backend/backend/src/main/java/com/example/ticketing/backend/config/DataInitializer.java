package com.example.ticketing.backend.config;

import com.example.ticketing.backend.model.Customer;
import com.example.ticketing.backend.model.Vendor;
import com.example.ticketing.backend.repository.CustomerRepository;
import com.example.ticketing.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * This class initializes the database with default data if it is empty.
 * It implements CommandLineRunner to execute the data initialization code
 * after the Spring Boot application starts.
 **/
@Component
public class DataInitializer implements CommandLineRunner {

    // Injecting the CustomerRepository to interact with Customer data in the database
    @Autowired
    private CustomerRepository customerRepository;

    // Injecting the VendorRepository to interact with Vendor data in the database
    @Autowired
    private VendorRepository vendorRepository;

    /**
     * This method runs after the application starts and checks if the
     * Customer and Vendor repositories are empty. If they are, it initializes
     * them with default data.
     **/
    @Override
    public void run(String... args) throws Exception {
        // Check if the Customer repository is empty
        if (customerRepository.count() == 0) {
            // Create and save the first default Customer
            Customer customer1 = new Customer();
            customer1.setName("Customer 1");
            customerRepository.save(customer1);

            // Create and save the second default Customer
            Customer customer2 = new Customer();
            customer2.setName("Customer 2");
            customerRepository.save(customer2);
        }

        // Check if the Vendor repository is empty
        if (vendorRepository.count() == 0) {
            // Create and save the first default Vendor
            Vendor vendor1 = new Vendor();
            vendor1.setName("Vendor 1");
            vendorRepository.save(vendor1);

            // Create and save the second default Vendor
            Vendor vendor2 = new Vendor();
            vendor2.setName("Vendor 2");
            vendorRepository.save(vendor2);
        }
    }
}
