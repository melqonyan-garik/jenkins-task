package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Getter
@Setter

public class Vehicle {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany
    private Collection<UserDetails> users;
}
