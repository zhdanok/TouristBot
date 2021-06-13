package io.github.zhdanok.tourist.web.repository;

import io.github.zhdanok.tourist.web.bean.City;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City, String> {
    @Override
    List<City> findAll();


    @Query(value = "SELECT info FROM city_info JOIN city c on city_info.id = c.id WHERE name_ru " +
            "= ?1 OR name_en = ?1", nativeQuery = true)
    String getInfoByCity(String name);

    @Query(value = "SELECT name_ru FROM city ", nativeQuery = true)
    List<String> getAllCities();
}
