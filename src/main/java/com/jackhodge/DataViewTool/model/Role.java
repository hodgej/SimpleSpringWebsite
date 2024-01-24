package com.jackhodge.DataViewTool.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();




}
