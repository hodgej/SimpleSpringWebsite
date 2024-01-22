package com.jackhodge.DataViewTool.model;

import jakarta.persistence.*;

@Entity
// maps to a sql table "Person". Note this would be the default with or without this annotation.
@Table(name = "Person")
public class Person {
    @Id // maps to our ID property
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Not annotated; default will map to columns that share same names
    private String firstName;
    private String lastName;

    // Protected constructor for JPA
    protected Person() {}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Constructor used to create Person instances to be saved to the database
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
