package com.maggeiro.nestquest.repository;

import com.maggeiro.nestquest.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
