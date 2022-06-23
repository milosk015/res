package com.milosskovac.rezervisi.service;

import com.milosskovac.rezervisi.repository.CityViewRepository;
import com.milosskovac.rezervisi.views.ViewCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ViewService {

        @Autowired
        CityViewRepository repo;

        public List<ViewCity> listAll() {
            return repo.findAll();
        }
    }

