package com.milosskovac.rezervisi.repository;

import com.milosskovac.rezervisi.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ActivityRepo extends JpaRepository<Activity,Integer> {
   // @Query(value="select id, name from Activity where id = :id")
    Optional<Activity> findById(@Param("id")Integer id);
 //   @Query(value="select id, name from Activity where name = :name")
    Activity findByName(@Param("name")String name);

    Activity save(Activity activity);

    @Modifying
    @Query(value="insert into activity values (:name, :city_id)", nativeQuery = true)
    void addActivity(@Param("name") String name, @Param("city_id") Integer city_id);


    void delete(Activity activity);
}
