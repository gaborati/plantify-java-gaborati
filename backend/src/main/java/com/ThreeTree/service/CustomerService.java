package com.ThreeTree.service;

import com.ThreeTree.dao.CustomerRepository;
import com.ThreeTree.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
