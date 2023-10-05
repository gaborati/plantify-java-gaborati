package com.ThreeTree.controller;
import com.ThreeTree.model.Person;
import com.ThreeTree.dto.NewCustomerRequest;
import com.ThreeTree.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class ApiController {
    private final CustomerService customerService;

    public ApiController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Person> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Person getCustomerById(@PathVariable("customerId") Integer id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Person person = new Person();
        person.setName(request.name());
        person.setEmail(request.email());
        customerService.saveCustomer(person);
    }


}
