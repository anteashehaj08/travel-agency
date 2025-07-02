package com.example.travel_agency.config.seeder;

import com.example.travel_agency.entities.Continent;
import com.example.travel_agency.repositories.ContinentRepository;
import com.example.travel_agency.statics.ContinentEnum;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ContinentSeeder implements ApplicationRunner {

    private final ContinentRepository repository;

    public ContinentSeeder(ContinentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) {
        Arrays.stream(ContinentEnum.values())
                .filter(enumVal -> repository.findByName(enumVal).isEmpty())
                .forEach(enumVal -> repository.save(new Continent(null, enumVal)));
    }
}
