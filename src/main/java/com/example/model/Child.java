package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child implements Serializable {
    private String name;

    public void setName(String name) {
        System.out.println("SETTTERRRRRRR");
        this.name = name;
    }
}
