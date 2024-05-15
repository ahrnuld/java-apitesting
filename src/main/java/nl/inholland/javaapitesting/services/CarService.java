package nl.inholland.javaapitesting.services;

import nl.inholland.javaapitesting.exceptions.InhollandValidationException;
import nl.inholland.javaapitesting.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car getById(long id);

    Car add(Car car);

    Car update(Car car, long id) throws InhollandValidationException;

    void delete(long id);
}
