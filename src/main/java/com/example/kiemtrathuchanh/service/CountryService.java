package com.example.kiemtrathuchanh.service;

import com.example.kiemtrathuchanh.model.City;
import com.example.kiemtrathuchanh.model.Country;
import com.example.kiemtrathuchanh.repository.ICityRepository;
import com.example.kiemtrathuchanh.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private ICountryRepository countryRepository;


    public Iterable<Country> findAll(){
        return countryRepository.findAll();
    }
    public Optional<Country> findById(Long id){
        return countryRepository.findById(id);
    }
    public Country save(Country country){
        return countryRepository.save(country);
    }
    public void delete(Long id){
        countryRepository.deleteById(id);
    }

}
