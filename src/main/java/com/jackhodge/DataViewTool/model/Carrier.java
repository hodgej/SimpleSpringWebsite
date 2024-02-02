package com.jackhodge.DataViewTool.model;

import jakarta.persistence.*;

@Entity
@Table(name="carrier")
public class Carrier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carrierid;

    private String name;


    public Carrier(String name) {
        this.name = name;
    }

    protected Carrier() {

    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return carrierid;
    }
}
