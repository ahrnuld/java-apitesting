package nl.inholland.javaapitesting.models.DTO;

public record CarDTO(
        long id,
        String brand,
        String licensePlate,
        int weight,
        long ownerId,
        String ownerFirstName,
        String ownerLastName
) {}