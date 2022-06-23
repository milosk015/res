package com.milosskovac.rezervisi.repository;

import com.milosskovac.rezervisi.views.ViewCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityViewRepository extends JpaRepository<ViewCity,String> {
}
