package io.github.zhdanok.tourist.web.repository;

import io.github.zhdanok.tourist.web.bean.City;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Repository
public interface CityRepository extends JpaRepository<City, String> {
    @Override
    List<City> findAll();

    @Query(value = "SELECT * FROM city WHERE name_ru = ?1", nativeQuery = true)
    List<City> findAllByNameRu(String nameRu);

    @Query(value = "SELECT * FROM city WHERE name_en = ?1", nativeQuery = true)
    List<City> findAllByNameEn(String nameEn);


    @Query(value = "SELECT info FROM city_info " +
            "JOIN city c on city_info.id = c.id " +
            "WHERE name_ru = ?1 OR name_en = ?1", nativeQuery = true)
    String getInfoByCity(String name);

    @Query(value = "SELECT name_ru FROM city ", nativeQuery = true)
    List<String> getAllCities();

    @Query(value = "SELECT name_en FROM city WHERE name_ru = ?1", nativeQuery = true)
    String getCityEnByCityRu(String nameRu);


    @Transactional
    @Modifying
    @Query(value = "UPDATE  city, city_info " +
            "SET city.name_en = ?2, city_info.info = ?3 " +
            "WHERE city.name_ru = ?1 AND city.id = city_info.id", nativeQuery = true)
    void setNewData(String nameRu, String nameEn, String info);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM city WHERE name_ru = ?1", nativeQuery = true)
    void deleteCityByCityRu(String nameRu);

}
