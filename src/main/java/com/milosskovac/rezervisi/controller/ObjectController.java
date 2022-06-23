package com.milosskovac.rezervisi.controller;

import com.milosskovac.rezervisi.exception.SQLEx;
import com.milosskovac.rezervisi.serviceImpl.ObjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLDataException;

@RestController
public class ObjectController {

    @Autowired
    private ObjectServiceImpl objectService;

    public ObjectController(ObjectServiceImpl objectService) {

        this.objectService = objectService;
    }

    @PostMapping(path = "/object/add")
    public String MainObject(@RequestParam(value = "objName", required = true) String objName,
                           @RequestParam(value = "objStreet", required = true) String objStreet,
                           @RequestParam(value = "objNumber", required = true) String objNumber,
                           @RequestParam(value = "objDistr", required = true) String objDistr,
                           @RequestParam(value = "cityName", required = true) String cityName,
                           @RequestParam(value = "activityName", required = true) String activityName) throws Exception {

        
        return objectService.MainObject(objName,objStreet,objNumber,objDistr,cityName,activityName);
    }
}
