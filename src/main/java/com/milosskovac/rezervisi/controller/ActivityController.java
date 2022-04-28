package com.milosskovac.rezervisi.controller;

import com.milosskovac.rezervisi.model.Activity;
import com.milosskovac.rezervisi.model.City;
import com.milosskovac.rezervisi.serviceImpl.ActivityServiceImpl;
import com.milosskovac.rezervisi.serviceImpl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ActivityController {

    @Autowired
    ActivityServiceImpl activityService;
    @Autowired
    CityServiceImpl cityService;

    @GetMapping(path = "/activity/name")
    public ResponseEntity<Activity> getActivityByName(@RequestParam(value="name", required = true) String name){
        Activity activity = activityService.findByName(name);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping(path = "/activity/id")
    public ResponseEntity<Optional> getActivityById(@RequestParam(value="id",required = true) Integer id){
        Optional<Activity> activity = activityService.findById(id);
        return new ResponseEntity<>(activity,HttpStatus.OK);
    }

    @PostMapping(path = "/activity/input")
     public Activity addActivity(@RequestParam(value="name",required = true) String name){
        City city = cityService.findByName("Banja");
        Activity activity = new Activity();
        activity.setName(name);
        activity.setCity(city);
        //Integer city_id = 9; //city.getId();
        return activityService.save(activity);

    }

}
