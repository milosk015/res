package com.milosskovac.rezervisi.controller;

import com.milosskovac.rezervisi.model.City;
import com.milosskovac.rezervisi.serviceImpl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @GetMapping(path = "/grad/name")
    public City getCityByName(@RequestParam(value = "name", required = true) String name) {
        return cityService.findByName(name);
    }

    @GetMapping(path = "/grad/id")
    public Optional<City> getCityById(@RequestParam(value = "id", required = true) Integer id) {
        return cityService.findById(id);
    }

    @GetMapping(path = "/gradovi")
    public List<City> getCities() {
        return cityService.getCities();
    }

    @PostMapping(path = "/grad/input")
    public City addCity(@Valid @RequestParam(value = "name", required = true) String name ) {
       City city = new City();
       city.setName(name);
       return cityService.save(city);
    }

   @PutMapping(path = "/grad/update")
    public City updateCity(@RequestParam(value = "oldName", required = true) String oldName,
                           @RequestParam(value = "newName", required = true) String newName) {
        return cityService.updateCity(oldName, newName);

    }

    @DeleteMapping(path = "/grad/delete")
    public void deleteCity(@RequestParam(value = "name", required = true) String name) {

        cityService.deleteCity(name);
    }
}
