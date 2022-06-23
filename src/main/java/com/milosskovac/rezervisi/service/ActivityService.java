package com.milosskovac.rezervisi.service;

import com.milosskovac.rezervisi.model.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {

    Activity findById(Integer id);
    Activity findByName(String name);
    List<Activity> getActivities();
    Activity save(Activity activity);
    void addActivity(String name, Integer city_id);
  //  Activity updateActivity(String oldName,String newName);
   // void deleteActivity(String name);
    // void deleteActivityId(Integer id);
}
