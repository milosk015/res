package com.milosskovac.rezervisi.controller;
import com.milosskovac.rezervisi.views.ViewCity;
import com.milosskovac.rezervisi.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewController {

    @Autowired
    private ViewService viewRepo;

    @GetMapping(path = "/view/city")
    public List<ViewCity> getViews() {
        return viewRepo.listAll();
    }
}
