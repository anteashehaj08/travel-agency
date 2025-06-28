package com.example.travel_agency.service.impl;

import com.example.travel_agency.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl {
    @Autowired
    TourRepository tourRepository;
}
