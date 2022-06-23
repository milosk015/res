package com.milosskovac.rezervisi.serviceImpl;

import com.milosskovac.rezervisi.DTO.CityDTO;
import com.milosskovac.rezervisi.exception.ElementExistException;
import com.milosskovac.rezervisi.exception.NoSuchElementFoundException;
import com.milosskovac.rezervisi.model.City;
import com.milosskovac.rezervisi.repository.CityRepo;
import com.milosskovac.rezervisi.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepo cityRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    @PersistenceContext
    private EntityManager em;

    public CityServiceImpl(CityRepo cityRepo){
        this.cityRepo = cityRepo;
    }

    @Override
    public CityDTO findById(Integer id) {
        City city = cityRepo.findId(id);
        if(city==null)throw new NoSuchElementFoundException("Nema grada pod tim ID-jem");
        CityDTO cityDTO = convertToDto(city);
        return cityDTO;
    }

    @Override
    public CityDTO findByName(String name) {
        if(cityRepo.findByName(name)==null)throw new NullPointerException("Nema grada pod tim nazivom");
        City city = cityRepo.findByName(name);
        CityDTO cityDTO = convertToDto(city);
        return cityDTO;
    }

    @Override
    public List<CityDTO> getCities() {
        List<City> cityList = cityRepo.findAll();
        return cityList.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CityDTO save(CityDTO cityDTO) {
        City city = convertToEntity(cityDTO);
        if(cityRepo.findByName(city.getName())!=null)throw new ElementExistException("Grad pod navedenim nazivom vec postoji");
      //  city.setName(city.getName());
        City citySaved = cityRepo.save(city);
        CityDTO cityDTOSaved = convertToDto(citySaved);
        return cityDTOSaved;
    }

    @Override
    public CityDTO updateCity(String oldName, String newName) {
        City city = cityRepo.findByName(oldName);
        city.setName(newName);
        City cityUpdated = cityRepo.save(city);
        CityDTO cityDTO = convertToDto(cityUpdated);
        return cityDTO;
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

    public List getCityCount(){

        return em.createNamedStoredProcedureQuery("getCityCount").getResultList();
    }

    private CityDTO convertToDto(City city) {
        CityDTO cityDTO = modelMapper.map(city, CityDTO.class);
        return cityDTO;
    }
    private City convertToEntity(CityDTO cityDTO) {
        City city = modelMapper.map(cityDTO, City.class);
        return city;
    }

}
