package com.maggeiro.nestquest.service;

import com.maggeiro.nestquest.Property;
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

    public Property getPropertyById(int id){
        return propertyRepository.findById(id).orElse(null);
    }

    public Property saveProperty(Property property){
        return propertyRepository.save(property);
    }

    public void deleteProperty(int id){
        propertyRepository.deleteById(id);
    }
}
