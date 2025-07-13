package com.example.travel_agency.service.impl;


import com.example.travel_agency.entities.City;
import com.example.travel_agency.entities.Hotel;
import com.example.travel_agency.repositories.CityRepository;
import com.example.travel_agency.repositories.HotelRepository;
import com.example.travel_agency.service.HotelService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@Data
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private CityRepository cityRepository;


    @Override
    public Hotel create(Long CityId, String name) {
            City city = cityRepository.findById(CityId).orElseThrow(()-> new RuntimeException("City not found"));
            Hotel hotel = new Hotel();
            hotel.setName(name);
            hotel.setCity(city);
            return hotelRepository.save(hotel);

    }

    @Override
    public Hotel update(String name, Long hotelId, Long cityId) {
        Hotel hotel = this.findById(hotelId);
        hotel.setName(name);
        if (!hotel.getCity().getId().equals(cityId))
        {
            City city = cityRepository.findById(cityId).orElseThrow(()-> new RuntimeException("City not found"));
            hotel.setCity(city);
        }
        return hotelRepository.save(hotel);

    }


    @Override
    public Hotel findById(Long Id) {
       return hotelRepository.findById(Id)
               .orElseThrow(()-> new RuntimeException("Hotel not found"));
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> findByCity(Long cityId) {
        return hotelRepository.findAllByCity_Id(cityId);
    }
}
