package com.example.APIBigboss.repository;

import com.example.APIBigboss.models.City;
import com.example.APIBigboss.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Integer> {
    @Query("SELECT bn FROM District bn")
    List<District> getAllDistrict();
}
