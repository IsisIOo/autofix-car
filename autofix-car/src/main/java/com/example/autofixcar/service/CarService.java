package com.example.autofixcar.service;

import com.example.autofixcar.entity.Car;
import com.example.autofixcar.model.Repair;
import com.example.autofixcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    @Autowired
    RestTemplate restTemplate;


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

    //encontrar todos los autos que son de cierto tipo
    public ArrayList<Car> getCarsbyType(String type){
        return (ArrayList<Car>) carRepository.findByType(type);
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