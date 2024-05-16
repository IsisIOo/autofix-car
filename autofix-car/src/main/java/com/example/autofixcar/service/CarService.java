package com.example.autofixcar.service;


import com.example.autofixcar.entity.Car;
import com.example.autofixcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    //obtiene todos los autos
    public ArrayList<Car> getAll(){
        return (ArrayList<Car>) carRepository.findAll();
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public Car getCarByPatent(String patent){
        return carRepository.findByPatent(patent);
    }

    public Car getCartById(long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car updateCar(Car car) {
        return carRepository.save(car);
    }

    public boolean deleteCar(Long id) throws Exception {
        try{
            carRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}