package com.milosskovac.rezervisi.repository;

import com.milosskovac.rezervisi.model.Objects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ObjectRepo extends JpaRepository<Objects, Integer> {


    @Procedure(name = "MainObject")
    public String MainObject(String objName, String objStreet, String objNumber,
                                String objDistr, String cityName, String activityName);
}
