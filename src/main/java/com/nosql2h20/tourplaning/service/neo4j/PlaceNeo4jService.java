package com.nosql2h20.tourplaning.service.neo4j;

import com.nosql2h20.tourplaning.entity.neo4j.PlaceNeo4j;
import com.nosql2h20.tourplaning.model.dto.PlaceDTO;
import com.nosql2h20.tourplaning.repository.neo4j.PlaceNeo4jRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceNeo4jService {

    @Autowired
    private PlaceNeo4jRepository repository;

    public PlaceNeo4j savePlace(PlaceDTO placeDTO) {
        return repository.save(new PlaceNeo4j(placeDTO));
    }


    public PlaceNeo4j getPlaceById(Long id) {
        Optional<PlaceNeo4j> company = repository.findById(id);
        return company.get();
    }

    public void deletePlaceById(Long id) {
        PlaceNeo4j place = getPlaceById(id);
        repository.delete(place);
    }

    public PlaceNeo4j updatePlace(PlaceDTO placeDTO) {
        PlaceNeo4j place = getPlaceById(placeDTO.getId());
        place.setName(placeDTO.getName());
        return repository.save(place);
    }
}
