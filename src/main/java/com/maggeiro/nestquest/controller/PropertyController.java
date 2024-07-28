package com.maggeiro.nestquest.controller;

import com.maggeiro.nestquest.Property;
import com.maggeiro.nestquest.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Property getPropertyById(@PathVariable int id){
        return propertyService.getPropertyById(id);
    }

    @PostMapping
    public Property createProperty(@RequestBody Property property){
        return propertyService.saveProperty(property);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable int id) {
        propertyService.deleteProperty(id);
    }


}
