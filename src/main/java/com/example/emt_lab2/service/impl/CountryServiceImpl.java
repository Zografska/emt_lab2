package com.example.emt_lab2.service.impl;

import com.example.emt_lab2.model.Country;
import com.example.emt_lab2.repository.CountryRepository;
import com.example.emt_lab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(String name, String continent) {
        return  countryRepository.save(new Country(name,continent));
    }

    @Override
    public List<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }
}
