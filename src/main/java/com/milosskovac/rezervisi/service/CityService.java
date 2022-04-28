package com.milosskovac.rezervisi.service;

import com.milosskovac.rezervisi.model.City;
import java.util.List;
import java.util.Optional;

public interface CityService {

    Optional<City> findById(Integer id);
    City findByName(String name);
    List<City> getCities();
    City save(City city);
    City updateCity(String oldName,String newName);
    void deleteCity(String name);
   // void deleteCityId(Integer id);
}
