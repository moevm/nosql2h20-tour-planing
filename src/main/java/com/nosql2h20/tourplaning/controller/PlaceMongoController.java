package com.nosql2h20.tourplaning.controller;


import com.nosql2h20.tourplaning.entity.mongo.PlaceMongo;
import com.nosql2h20.tourplaning.model.dto.PlaceDTO;
import com.nosql2h20.tourplaning.service.mongo.PlaceMongoService;
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
@RequestMapping(value = "/ajax/mongo")
public class PlaceMongoController {

    @Autowired
    private PlaceMongoService service;

    @PostMapping("/save")
    private PlaceMongo savePlace(@RequestBody PlaceDTO place) {
        return service.savePlace(place);
    }

    @GetMapping("/get")
    private PlaceMongo getPlace(@RequestParam Long id) {
        return service.getPlaceById(id);
    }

    @DeleteMapping("/delete")
    private String deletePlace(@RequestParam Long id) {
        service.deletePlaceById(id);
        return "PlaceMongo with id" + id + "successful deleted";
    }

    @PutMapping("/update")
    private PlaceMongo updatePlace(@RequestBody PlaceDTO place) {
        return service.updatePlace(place);
    }
}
