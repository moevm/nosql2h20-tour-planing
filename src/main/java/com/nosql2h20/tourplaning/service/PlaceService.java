package com.nosql2h20.tourplaning.service;

import com.nosql2h20.tourplaning.entity.Place;
import com.nosql2h20.tourplaning.model.PlaceDTO;
import com.nosql2h20.tourplaning.repository.PlaceRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Data
public class PlaceService {

    @Autowired
    private PlaceRepository repository;

    public Place savePlace(PlaceDTO placeDto) {
        var newPlace = new Place(placeDto.getName(), placeDto.getDescription(), placeDto.getImageUrl(), placeDto.getLatitude(), placeDto.getLongitude(), placeDto.getAddress());

        return repository.save(newPlace);
    }


    public Place getPlaceById(UUID id) {
        var company = repository.findById(id);

        return company.get();
    }

    public void deletePlaceById(UUID id) {
        var place = getPlaceById(id);
        repository.delete(place);
    }

    public Place updatePlace(PlaceDTO placeDTO) {
        var place = getPlaceById(placeDTO.getId());
        place.setName(placeDTO.getName());

        return repository.save(place);
    }
}
