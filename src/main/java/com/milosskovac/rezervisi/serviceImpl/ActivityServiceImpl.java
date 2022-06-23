package com.milosskovac.rezervisi.serviceImpl;

import com.milosskovac.rezervisi.exception.ElementExistException;
import com.milosskovac.rezervisi.exception.NoSuchElementFoundException;
import com.milosskovac.rezervisi.model.Activity;
import com.milosskovac.rezervisi.repository.ActivityRepo;
import com.milosskovac.rezervisi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepo activityRepo;

    public ActivityServiceImpl(ActivityRepo activityRepo){

        this.activityRepo = activityRepo;
    }

    @Override
    public Activity findById(Integer id) {
        Activity activity = activityRepo.findId(id);
        if(activity==null)throw new NoSuchElementFoundException("Nema delatnosti pod tim ID-jem");
        return activity;
    }

    @Override
    public Activity findByName(String name) {
        if(activityRepo.findByName(name)==null)throw new NullPointerException("Nema delatnosti pod tim nazivom");
        return activityRepo.findByName(name);
    }

    @Override
    public List<Activity> getActivities() {

        return activityRepo.findAll();
    }

    @Override
    public Activity save(Activity activity) {
        if(activityRepo.findByName(activity.getName())!=null)throw new ElementExistException("Delatnost pod navedenim nazivom vec postoji");
        return activityRepo.save(activity);
    }

    @Override
    public void addActivity(String name, Integer city_id) {
         activityRepo.addActivity(name, city_id);
    }

 /*   @Override
    public Activity updateActivity(String oldName, String newName) {
        Activity activity = activityRepo.findByName(oldName);
        activity.setName(newName);
        return activityRepo.save(activity);
    }

    @Override
    public void deleteActivity(String name) {
        Activity activity = activityRepo.findByName(name);
        activityRepo.delete(activity);
    }*/
}
