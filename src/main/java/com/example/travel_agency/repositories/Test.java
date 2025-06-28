package com.example.travel_agency.repositories;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Test {
    @Autowired
    private EntityManager entityManager;


}
