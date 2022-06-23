package com.milosskovac.rezervisi.service;

import com.milosskovac.rezervisi.DTO.CityDTO;
import java.util.List;

public interface CityService {

    CityDTO findById(Integer id);
    CityDTO findByName(String name);
    List<CityDTO> getCities();
    CityDTO save(CityDTO city);
    CityDTO updateCity(String oldName,String newName);
    void deleteCity(String name);
   // void deleteCityId(Integer id);


}
