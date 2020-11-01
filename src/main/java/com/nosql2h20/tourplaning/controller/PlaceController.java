package com.nosql2h20.tourplaning.controller;

import com.nosql2h20.tourplaning.model.Place;
import com.nosql2h20.tourplaning.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/ajax")
public class PlaceController {

    @Autowired
    private PlaceService service;

    @PostMapping("/save")
    private Place savePlace(@RequestBody Place place) {
        return service.savePlace(place);
    }

    @GetMapping("/get")
    private Place getPlace(@RequestParam Long id) {
        return service.getPlaceById(id);
    }
}
