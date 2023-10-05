package com.ThreeTree.service;

import com.ThreeTree.dao.PersonRepository;
import com.ThreeTree.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getCustomers() {
        return personRepository.findAll();
    }

    public Person getCustomerById(Integer id) {
        return personRepository.findById(id).orElseThrow();
    }


    public void saveCustomer(Person person) {
        personRepository.save(person);
    }
}
