package com.maggeiro.nestquest;

import com.maggeiro.nestquest.entity.Property;
import com.maggeiro.nestquest.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NestquestApplication implements CommandLineRunner {

	@Autowired
	private PropertyService propertyService;

	public static void main(String[] args) {
		SpringApplication.run(NestquestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create a new property
		Property newProperty = new Property();
		newProperty.setStreetAddress("123 Test St");
		newProperty.setCity("Testville");
		newProperty.setCounty("Testshire");
		newProperty.setEircode("TST123");
		newProperty.setPrice(250000.00);
		newProperty.setNumOfBedrooms(3);
		newProperty.setNumOfBathrooms(2);
		newProperty.setSqm(120.0);
		newProperty.setParkingSpaces(2);
		newProperty.setEnergyRating("B");

		Property createdProperty = propertyService.createProperty(newProperty);
		System.out.println("Created Property: " + createdProperty);

		// Get all properties
		System.out.println("All Properties:");
		propertyService.getAllProperties().forEach(System.out::println);

		// Get property by ID
		Property fetchedProperty = propertyService.getPropertyById(createdProperty.getId());
		System.out.println("Fetched Property by ID: " + fetchedProperty);

		// Delete the property
		propertyService.deleteProperty(createdProperty.getId());
		System.out.println("Deleted Property with ID: " + createdProperty.getId());

		// Verify deletion
		try {
			propertyService.getPropertyById(createdProperty.getId());
		} catch (Exception e) {
			System.out.println("Property not found after deletion: " + createdProperty.getId());
		}
	}
}
