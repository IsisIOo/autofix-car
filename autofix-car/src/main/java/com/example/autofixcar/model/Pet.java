package com.example.autofixcar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//cambiarle el nombre en el futuro
public class Pet {
    private String type;
    private String name;
    private int studentId;
}
