package com.jackhodge.DataViewTool.model;

import jakarta.persistence.*;

@Entity
// maps to a sql table "Person". Note this would be the default with or without this annotation.
@Table(name = "Truckload")
public class Truckload {
    @Id // maps to our ID property
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Not annotated; default will map to columns that share same names
    private String source;
    private String destination;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name =  "carrierid")
    private Carrier carrier;


    // Protected constructor for JPA
    protected Truckload() {}

    @Override
    public String toString() {
        return "Truckload{" +
                "id=" + id +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    // Constructor used to create Person instances to be saved to the database
    public Truckload(String firstName, String lastName, Carrier carrier) {
        this.source = firstName;
        this.destination = lastName;
        this.carrier = carrier;
    }



}
