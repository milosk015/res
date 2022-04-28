package com.milosskovac.rezervisi.repository;

import com.milosskovac.rezervisi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CityRepo extends JpaRepository<City,Integer> {
    @Query(value="select id, name from City where id = :id")
    Optional<City> findById(@Param("id") Integer id);
  //  @Query(value="select id, name from City where name = :name")
    City findByName(@Param("name") String name);

    City save(City city );

    void delete(City city);


}
