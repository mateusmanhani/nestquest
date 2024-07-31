package com.maggeiro.nestquest.controller;

import com.maggeiro.nestquest.entity.Property;
import com.maggeiro.nestquest.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable int id) {
        Property property = propertyService.getPropertyById(id);
        if (property == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(property);
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property createdProperty = propertyService.createProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProperty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable int id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
