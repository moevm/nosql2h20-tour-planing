package com.nosql2h20.tourplaning.controller;

import com.nosql2h20.tourplaning.model.PlaceDTO;
import com.nosql2h20.tourplaning.service.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/place")
public class PlaceNeo4jController {

    private final PlaceService service;

    public PlaceNeo4jController(PlaceService service) {
        this.service = service;
    }

    @PostMapping("/save")
    private PlaceDTO savePlace(@RequestBody PlaceDTO place) {
        return service.savePlace(place);
    }

    @GetMapping("/get")
    private PlaceDTO getPlace(@RequestParam Long id) {
        return service.getPlaceById(id);
    }

    @DeleteMapping("/delete")
    private HttpStatus deletePlace(@RequestParam Long id) {
        service.deletePlaceById(id);

        return HttpStatus.OK;
    }

    @PutMapping("/update")
    private PlaceDTO updatePlace(@RequestBody PlaceDTO place) {
        return service.updatePlace(place);
    }
}
