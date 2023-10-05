package com.ThreeTree.dao;

import com.ThreeTree.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Person, Integer> {
}
