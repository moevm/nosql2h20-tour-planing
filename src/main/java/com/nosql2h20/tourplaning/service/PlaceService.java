package com.nosql2h20.tourplaning.service;

import com.nosql2h20.tourplaning.entity.Path;
import com.nosql2h20.tourplaning.entity.Place;
import com.nosql2h20.tourplaning.model.NewPlaceDTO;
import com.nosql2h20.tourplaning.model.PlaceDTO;
import com.nosql2h20.tourplaning.repository.IPathRepository;
import com.nosql2h20.tourplaning.repository.IPlaceRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PlaceService {

    private final IPlaceRepository repository;
    private IPathRepository pathRepository;

    public PlaceService(IPlaceRepository repository, IPathRepository pathRepository) {
        this.repository = repository;
        this.pathRepository = pathRepository;
    }

    public PlaceDTO savePlace(NewPlaceDTO placeDto) {
        var savedPlace = repository.save(new Place(placeDto.getName(), placeDto.getDescription(),
                placeDto.getImageUrl(), placeDto.getLatitude(), placeDto.getLongitude(), placeDto.getAddress()), 0);

        var paths = new ArrayList<Path>();
        placeDto.getPaths().forEach((x, y) ->
                {
                    var place = repository.findById(x).get();
                    paths.add(new Path(y.getName(), y.getDistance(), savedPlace, place));
                }
                );
        pathRepository.saveAll(paths);

        return getPlaceById(savedPlace.getId());
    }

    public PlaceDTO getPlaceById(Long id) {
        var place = repository.findById(id).get();

        return mapPlace(place);
    }

    public List<PlaceDTO> getAll() {
        var allPlaces = (List<Place>) repository.findAll();

        return allPlaces.stream().map(this::mapPlace).collect(Collectors.toList());
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
                        .map(Place::getId)
                        .collect(Collectors.toList())
        );
    }
}
