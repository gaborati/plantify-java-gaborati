package com.ThreeTree.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Person {
    public Person(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )


    private Integer id;

    public Person() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}