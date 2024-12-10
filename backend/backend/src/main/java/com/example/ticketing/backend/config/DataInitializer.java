package com.example.ticketing.backend.config;

import com.example.ticketing.backend.model.Customer;
import com.example.ticketing.backend.model.Vendor;
import com.example.ticketing.backend.repository.CustomerRepository;
import com.example.ticketing.backend.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() == 0) {
            Customer customer1 = new Customer();
            customer1.setName("Customer 1");
            customerRepository.save(customer1);

            Customer customer2 = new Customer();
            customer2.setName("Customer 2");
            customerRepository.save(customer2);
        }

        if (vendorRepository.count() == 0) {
            Vendor vendor1 = new Vendor();
            vendor1.setName("Vendor 1");
            vendorRepository.save(vendor1);

            Vendor vendor2 = new Vendor();
            vendor2.setName("Vendor 2");
            vendorRepository.save(vendor2);
        }
    }
}
