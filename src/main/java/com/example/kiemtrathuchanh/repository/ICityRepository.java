package com.example.kiemtrathuchanh.repository;
import com.example.kiemtrathuchanh.model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {


}
