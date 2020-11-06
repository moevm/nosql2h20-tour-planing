package com.nosql2h20.tourplaning.controller;

import com.nosql2h20.tourplaning.entity.neo4j.PlaceNeo4j;
import com.nosql2h20.tourplaning.model.dto.PlaceDTO;
import com.nosql2h20.tourplaning.service.neo4j.PlaceNeo4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/ajax/neoj4")
public class PlaceNeo4jController {

    @Autowired
    private PlaceNeo4jService service;

    @PostMapping("/save")
    private PlaceNeo4j savePlace(@RequestBody PlaceDTO place) {
        return service.savePlace(place);
    }

    @GetMapping("/get")
    private PlaceNeo4j getPlace(@RequestParam Long id) {
        return service.getPlaceById(id);
    }

    @DeleteMapping("/delete")
    private String deletePlace(@RequestParam Long id) {
        service.deletePlaceById(id);
        return "PlaceMongo with id" + id + "successful deleted";
    }

    @PutMapping("/update")
    private PlaceNeo4j updatePlace(@RequestBody PlaceDTO place) {
        return service.updatePlace(place);
    }
}
