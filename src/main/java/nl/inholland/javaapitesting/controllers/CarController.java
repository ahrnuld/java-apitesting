package nl.inholland.javaapitesting.controllers;

import nl.inholland.javaapitesting.exceptions.InhollandValidationException;
import nl.inholland.javaapitesting.models.Car;
import nl.inholland.javaapitesting.models.DTO.CarDTO;
import nl.inholland.javaapitesting.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cars")
public class CarController {

    private CarService carService;

    @GetMapping
    public List<CarDTO> getAll() {

        List<Car> cars = carService.getAll();

        List<CarDTO> dtos = cars.stream().map(car -> new CarDTO(
                car.getId(),
                car.getBrand(),
                car.getLicensePlate(),
                car.getWeight(),
                car.getOwner().getId(),
                car.getOwner().getFirstName(),
                car.getOwner().getLastName()))
                .collect(Collectors.toList());

        return dtos;
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable long id) {
        return carService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Car> add(@RequestBody Car car) {

        return ResponseEntity.status(201).body(carService.add(car));
    }

    @PutMapping("/{id}")
    public Car update(@RequestBody Car car, @PathVariable long id) throws InhollandValidationException {

        return carService.update(car, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        carService.delete(id);
    }

}
