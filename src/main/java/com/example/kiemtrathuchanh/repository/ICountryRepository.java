package com.example.kiemtrathuchanh.repository;

import com.example.kiemtrathuchanh.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Long> {
}
