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

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityController {

    @Autowired
    ActivityServiceImpl activityService;
    @Autowired
    CityServiceImpl cityService;

    @GetMapping(path = "/activity/name")
    public ResponseEntity<Activity> getActivityByName(@RequestParam(value="name", required = true) String name){
        return ResponseEntity.ok(activityService.findByName(name));
    }

    @GetMapping(path = "/activity/id")
    public ResponseEntity<Activity> getActivityById(@RequestParam(value="id",required = true) Integer id){
        return ResponseEntity.ok(activityService.findById(id));

    }

    @GetMapping(path="/activity/list")
    public ResponseEntity<List<Activity>> getActivityList(){
        return ResponseEntity.ok(activityService.getActivities());
    }

   /* @PostMapping(path = "/activity/input")
     public ResponseEntity<Activity> addActivity(@RequestParam(value="name",required = true) String name,
                                                  @RequestParam(value="cityName",required = true) String cityName){
        City city = cityService.findByName(cityName);
        Activity activity = new Activity();
        activity.setName(name);
        activity.setCity(city);
        activityService.save(activity);
        return new ResponseEntity<>(activity,HttpStatus.OK);

    }*/

}
