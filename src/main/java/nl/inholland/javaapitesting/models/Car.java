package nl.inholland.javaapitesting.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private long id;

    private String brand;

    private int weight = 0;

    @NotBlank(message = "License plate is mandatory")
    private String licensePlate;

    @ManyToOne
    private Person owner;

    public void setWeight(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be less than zero");
        }
        this.weight = weight;
    }
}
