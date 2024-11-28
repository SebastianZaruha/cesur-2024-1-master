package com.cinexpress.videofriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerService.createCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/{customerId}/companies/{companyId}")
    public ResponseEntity<Void> addClientToCompany(@PathVariable Long customerId, @PathVariable Long companyId) {
        try {
            customerService.addClientToCompany(customerId, companyId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/premium")
    public ResponseEntity<Boolean> hasPremiumSubscription(@PathVariable Long id) {
        boolean hasPremium = customerService.hasPremiumSubscription(id);
        return new ResponseEntity<>(hasPremium, HttpStatus.OK);
    }

    @PutMapping("/{id}/premium/deactivate")
    public ResponseEntity<Void> deactivatePremiumSubscription(@PathVariable Long id) {
        customerService.deactivatePremiumSubscription(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
