package com.ThreeTree.service;

import com.ThreeTree.dao.CustomerRepository;
import com.ThreeTree.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Person> getCustomers() {
        return customerRepository.findAll();
    }

    public Person getCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow();
    }


    public void saveCustomer(Person person) {
        customerRepository.save(person);
    }
}
