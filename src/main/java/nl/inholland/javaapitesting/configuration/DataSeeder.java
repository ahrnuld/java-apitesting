package nl.inholland.javaapitesting.configuration;

import nl.inholland.javaapitesting.models.Car;
import nl.inholland.javaapitesting.models.Person;
import nl.inholland.javaapitesting.services.CarService;
import nl.inholland.javaapitesting.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataSeeder implements ApplicationRunner {

    @Autowired
    CarService carService;

    @Autowired
    PersonService personService;

    @Override
    public void run(ApplicationArguments args) {

        Person person1 = new Person(1, "Luc", "Besson", new ArrayList<>());
        personService.add(person1);

        Car car1 = new Car(1, "Mercedes", 2000, "A class", person1);
        carService.add(car1);
    }
}
