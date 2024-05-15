package nl.inholland.javaapitesting.repositories;

import nl.inholland.javaapitesting.models.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    Iterable<Car> findAllByBrandLike(String brand);
}
