package com.ThreeTree.service;

import com.ThreeTree.dao.PersonRepository;
import com.ThreeTree.dto.NewPersonRequest;
import com.ThreeTree.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getCustomers() {
        return personRepository.findAll();
    }

    public Person getCustomerById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public void saveCustomer(NewPersonRequest request) {
        Person person = new Person();
        person.setFirstName(request.FirstName());
        person.setLastName(request.LastName());
        person.setEmail(request.email());
        personRepository.save(person);
    }

    public void updateCustomerById(Long id, Person person) {
        Person personToUpdate = personRepository.findById(id).orElseThrow();
        personToUpdate.setFirstName(person.getFirstName());
        personToUpdate.setLastName(person.getLastName());
        personToUpdate.setEmail(person.getEmail());
        personRepository.save(personToUpdate);
    }

    public void deleteCustomerById(Long id) {
        personRepository.deleteById(id);
    }
}
