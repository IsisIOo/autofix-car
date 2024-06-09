package com.example.autofixcar.repository;

import com.example.autofixcar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT * FROM car WHERE car.patent = :patent", nativeQuery = true)
    Car findByPatent(@Param("patent") String patent);

    @Query(value = "SELECT * FROM car WHERE car.type = :type", nativeQuery = true)
    ArrayList<Car> findByType(@Param("type") String type);
}
