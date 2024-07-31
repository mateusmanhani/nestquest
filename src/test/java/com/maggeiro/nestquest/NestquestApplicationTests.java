package com.maggeiro.nestquest;

import com.maggeiro.nestquest.entity.Property;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestquestApplicationTests {

	@Test
	void testGetAddress() {
		Property property = new Property();
		property.setStreetAddress("123 Main St");
		property.setCity("Springfield");
		property.setCounty("Greene");
		property.setEircode("12345");

		String expectedAddress = "123 Main St, Springfield, Greene, 12345";
		assertEquals(expectedAddress, property.getAddress());
	}
}
