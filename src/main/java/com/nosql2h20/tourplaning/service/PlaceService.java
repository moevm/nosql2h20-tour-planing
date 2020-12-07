package com.nosql2h20.tourplaning.service;

import com.nosql2h20.tourplaning.entity.Place;
import com.nosql2h20.tourplaning.model.PlaceDTO;
import com.nosql2h20.tourplaning.repository.IPlaceRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Data
public class PlaceService {

    private final IPlaceRepository repository;

    public PlaceService(IPlaceRepository repository) {
        this.repository = repository;
    }

    public PlaceDTO savePlace(PlaceDTO placeDto) {
        var newPlace = new Place(placeDto.getName(), placeDto.getDescription(), placeDto.getImageUrl(), placeDto.getLatitude(), placeDto.getLongitude(), placeDto.getAddress());

        repository.save(newPlace);

        return mapPlace(newPlace);
    }

    public PlaceDTO getPlaceById(Long id) {
        var company = repository.findById(id);
        var place = company.get();

        return mapPlace(place);
    }

    public void deletePlaceById(Long id) {
        repository.deleteById(id);
    }

    public PlaceDTO updatePlace(PlaceDTO placeDTO) {
        var company = repository.findById(placeDTO.getId());
        var place = company.get();
        place.setName(placeDTO.getName());
        place.setDescription(placeDTO.getDescription());
        place.setAddress(placeDTO.getAddress());
        place.setLatitude(placeDTO.getLatitude());
        place.setLongitude(placeDTO.getLongitude());

        repository.save(place);

        return mapPlace(place);
    }

    private PlaceDTO mapPlace(Place place) {
        return new PlaceDTO(place.getId(),
                place.getName(),
                place.getDescription(),
                place.getImageUrl(),
                place.getLatitude(),
                place.getLongitude(),
                place.getAddress(),
                place.getPlaces()
                        .stream()
                        .map(x -> new PlaceDTO(x.getId(), x.getName(), x.getDescription(),
                                x.getImageUrl(),x.getLatitude(),x.getLongitude(),x.getAddress()))
                        .collect(Collectors.toList())
        );
    }
}
