package com.nosql2h20.tourplaning.service.mongo;


import com.nosql2h20.tourplaning.entity.mongo.PlaceMongo;
import com.nosql2h20.tourplaning.model.dto.PlaceDTO;
import com.nosql2h20.tourplaning.repository.mongo.PlaceMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceMongoService {

    @Autowired
    private PlaceMongoRepository repository;

    public PlaceMongo savePlace(PlaceDTO placeDTO) {
        PlaceMongo placeMongo= new PlaceMongo(placeDTO);
        return repository.save(placeMongo);
    }


    public PlaceMongo getPlaceById(Long id) {
        Optional<PlaceMongo> company = repository.findById(id);
        return company.get();
    }

    public void deletePlaceById(Long id) {
        PlaceMongo place = getPlaceById(id);
        repository.delete(place);
    }

    public PlaceMongo updatePlace(PlaceDTO placeDTO) {
        PlaceMongo place = getPlaceById(placeDTO.getId());
        place.setName(placeDTO.getName());
        return repository.save(place);
    }
}
