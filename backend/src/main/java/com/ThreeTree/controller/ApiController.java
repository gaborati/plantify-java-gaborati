package com.ThreeTree.controller;
import com.ThreeTree.model.Person;
import com.ThreeTree.dto.NewPersonRequest;
import com.ThreeTree.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class ApiController {
    private final PersonService personService;

    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getCustomers() {
        return personService.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Person getCustomerById(@PathVariable("customerId") Integer id) {
        return personService.getCustomerById(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody NewPersonRequest request) {
        Person person = new Person();
        person.setName(request.name());
        person.setEmail(request.email());
        personService.saveCustomer(person);
    }


}
