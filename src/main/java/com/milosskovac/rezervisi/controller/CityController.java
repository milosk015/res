package com.milosskovac.rezervisi.controller;

import com.milosskovac.rezervisi.DTO.CityDTO;
import com.milosskovac.rezervisi.serviceImpl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
public class CityController {

    @Autowired
    private CityServiceImpl cityService;

    @GetMapping(path = "/city/name")
    public ResponseEntity<CityDTO> getCityByName(@Valid @NotEmpty(message = "Neispravan unos - ime je obavezno")
                                     @RequestParam(value = "name", required = true) String name) {
        CityDTO cityDTO = cityService.findByName(name);
        return ResponseEntity.ok(cityDTO);
    }

    @GetMapping(path = "/city/id")
    public ResponseEntity<CityDTO> getCityById(@RequestParam(value = "id", required = true) Integer id) {
        return ResponseEntity.ok(cityService.findById(id));
    }

    @GetMapping(path = "/city/list")
    public ResponseEntity<List<CityDTO>> getCities() {
        return ResponseEntity.ok(cityService.getCities());
    }

    @GetMapping("/cityCount")
    public ResponseEntity<List>  getCityCount(){
        return ResponseEntity.ok(cityService.getCityCount());
    }

    @PostMapping(path = "/city/input")
    public ResponseEntity<CityDTO> addCity(@Valid @RequestBody CityDTO cityDTO ) {
       cityDTO.getName();
       return ResponseEntity.ok(cityService.save(cityDTO));
    }

   @PutMapping(path = "/city/update")
    public ResponseEntity<CityDTO> updateCity(@Valid @RequestParam(value = "oldName", required = true) @
           NotNull(message = "Name is mandatory")String oldName,
                             @Valid @RequestParam(value = "newName", required = true) @NotNull(message = "Name is mandatory") String newName) {
        return ResponseEntity.ok(cityService.updateCity(oldName, newName));   // nisi obradio kad postoji novo ime vec i obrnuto

    }

    @DeleteMapping(path = "/city/delete")
    public void deleteCity(@RequestParam(value = "name", required = true) String name) {
        cityService.deleteCity(name);
    }
}
