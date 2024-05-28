package com.example.autofixcar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//ESTE CORRESPONDE AL MICROSERVICIO 1
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private Long id; //no lo asigno

    private String patent; //patente de 4 letras y 2 numeros

    private String brand; //marca del vehiculo

    private String model; //modelo del vehiculo suzuki swift -> swift modelo

    private String type; //tipo de vehiculo, Sedan, Hatchback, SUV, Pickup, Furgoneta

    private int productionYear; //año de fabricacion

    private String motorType; //tipo de motor gasolina, diesel, hibrido y electrico

    private int numberSeats; //numero de asientos

    private int kilometers; //kilometraje del vehiculo
}
