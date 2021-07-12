package com.example.kiemtrathuchanh.service;

import com.example.kiemtrathuchanh.model.City;
import com.example.kiemtrathuchanh.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private ICityRepository cityRepository;


    public Iterable<City> findAll(){
        return cityRepository.findAll();
    }
    public Optional<City> findById(Long id){
        return cityRepository.findById(id);
    }
    public City save(City city){
        return cityRepository.save(city);
    }
    public void delete(Long id){
        cityRepository.deleteById(id);
    }

}
