package com.example.autofixcar.controller;

import com.example.autofixcar.entity.Car;
import com.example.autofixcar.model.Repair;
import com.example.autofixcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    CarService carService;

    private static final Pattern PATENT_PATTERN = Pattern.compile("^[A-Za-z]{4}[0-9]{2}$");

    //obtiene todos
    @GetMapping("/")
    public ResponseEntity<List<Car>> getAll() {
        List<Car> cars = carService.getAll();
        if(cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    //encontrar solo uno
    @GetMapping("/carpatent/{patent}")
    public ResponseEntity<Car> getCarBypatent(@PathVariable String patent) {
        Car car = carService.getCarByPatent(patent);
        if(car == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    @GetMapping("/car-type/{patent}")
    public ResponseEntity<List<Car>> getCarBytype(@PathVariable String type) {
        List<Car> car = carService.getCarsbyType(type);
        if(car == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    @GetMapping("/carid/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") int id) {
        Car car = carService.getCartById(id);
        if(car == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(car);
    }

    //postear un auto
    @PostMapping("/")
    public ResponseEntity<?> saveCar(@RequestBody Car car) {
        // Validar el formato de la patente
        if (!PATENT_PATTERN.matcher(car.getPatent()).matches()) {
            return ResponseEntity.badRequest().body("Invalid patent format. It should be 4 letters followed by 2 numbers.");
        }

        // Obtener todos los autos
        List<Car> existingCars = carService.getAll();

        // Verificar si la patente ya existe en la lista de autos existentes
        for (Car existingCar : existingCars) {
            if (existingCar.getPatent().equals(car.getPatent())) {
                return ResponseEntity.badRequest().body("Car with this patent already exists.");
            }
        }

        // Guardar el nuevo auto si la patente no existe
        Car carNew = carService.saveCar(car);
        return ResponseEntity.ok(carNew);
    }



    /* por ahora no lo quiero
    @PutMapping("/")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        Car carUpdated = carService.updateCar(car);
        return ResponseEntity.ok(carUpdated);
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCarById(@PathVariable Long id) throws Exception {
        var isDeleted = carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }




/* ESTO ES LO NUEVO, CUANDO ESTEN CREADOS LOS OTROS PONERLO
    @GetMapping("/books/{studentId}")
    public ResponseEntity<List<Book>> getBooks(@PathVariable("studentId") int studentId) {
        Student student = studentService.getStudentById(studentId);
        if(student == null)
            return ResponseEntity.notFound().build();
        List<Book> books = studentService.getBooks(studentId);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/pets/{studentId}")
    public ResponseEntity<List<Pet>> getPets(@PathVariable("studentId") int studentId) {
        Student student = studentService.getStudentById(studentId);
        if(student == null)
            return ResponseEntity.notFound().build();
        List<Pet> pets = studentService.getPets(studentId);
        return ResponseEntity.ok(pets);
    }

    @PostMapping("/savebook/{studentId}")
    public ResponseEntity<Book> saveBook(@PathVariable("studentId") int studentId, @RequestBody Book book) {
        if(studentService.getStudentById(studentId) == null)
            return ResponseEntity.notFound().build();
        Book bookNew = studentService.saveBook(studentId, book);
        return ResponseEntity.ok(book);
    }

    @PostMapping("/savepet/{studentId}")
    public ResponseEntity<Pet> savePet(@PathVariable("studentId") int studentId, @RequestBody Pet pet) {
        if(studentService.getStudentById(studentId) == null)
            return ResponseEntity.notFound().build();
        Pet petNew = studentService.savePet(studentId, pet);
        return ResponseEntity.ok(pet);


    @GetMapping("/bystudent/{studentId}")
    public ResponseEntity<List<Pet>> getByStudentId(@PathVariable("studentId") int studentId) {
        List<Pet> pets = petService.byStudentId(studentId);
        return ResponseEntity.ok(pets);
    }
    }*/

}
