package com.example.emt_lab2.service;

import com.example.emt_lab2.model.Country;

import java.util.List;

public interface CountryService {
    Country create(String name, String continent);
    List<Country> findByName(String name);
}
