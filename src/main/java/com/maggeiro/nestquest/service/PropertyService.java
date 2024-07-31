package com.maggeiro.nestquest.service;

import com.maggeiro.nestquest.entity.Property;
import com.maggeiro.nestquest.exception.ResourceNotFoundException;
import com.maggeiro.nestquest.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties(){
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Integer id){
        return propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found for this id: " + id));
    }

    public Property createProperty(Property property){
        return propertyRepository.save(property);
    }

    public void deleteProperty(Integer id){
        Property property = propertyRepository.findById(id)
                        .orElseThrow(()  -> new ResourceNotFoundException("Property not found for id: " +id));
        propertyRepository.deleteById(id);
    }
}
