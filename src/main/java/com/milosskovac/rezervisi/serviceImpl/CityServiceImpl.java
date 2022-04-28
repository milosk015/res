package com.milosskovac.rezervisi.serviceImpl;

import com.milosskovac.rezervisi.exception.ElementExistException;
import com.milosskovac.rezervisi.exception.NoSuchElementFoundException;
import com.milosskovac.rezervisi.model.City;
import com.milosskovac.rezervisi.repository.CityRepo;
import com.milosskovac.rezervisi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepo cityRepo;

    public CityServiceImpl(CityRepo cityRepo){
        this.cityRepo = cityRepo;
    }

    @Override
    public Optional<City> findById(Integer id) {
        Optional<City> city = cityRepo.findById(id);
        if(city.isEmpty())throw new NoSuchElementFoundException("Nema grada pod tim ID-jem");
        return city;
    }

    @Override
    public City findByName(String name) {
        if(cityRepo.findByName(name)==null)throw new NullPointerException("Nema grada pod tim nazivom");
        return cityRepo.findByName(name);
    }

    @Override
    public List<City> getCities() {

        return cityRepo.findAll();
    }

    @Override
    public City save(City city) {
        if(cityRepo.findByName(city.getName())!=null)throw new ElementExistException("Grad pod navedenim nazivom vec postoji");
      //  city.setName(city.getName());
        return cityRepo.save(city);
    }

    @Override
    public City updateCity(String oldName, String newName) {
        City city = cityRepo.findByName(oldName);
        city.setName(newName);
        return cityRepo.save(city);
    }

    @Override
    public void deleteCity(String name) {
        City city = cityRepo.findByName(name);
        cityRepo.delete(city);
    }

    /*@Override
    public void deleteGradId(Integer id) {
        Optional<Grad> grad = cityRepo.findById(id);
        cityRepo.delete(grad);
    }*/
}
