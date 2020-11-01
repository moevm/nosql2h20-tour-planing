package com.nosql2h20.tourplaning.service;

import com.nosql2h20.tourplaning.model.Place;
import com.nosql2h20.tourplaning.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository companyRepository;

    public Place savePlace(Place company) {
        return companyRepository.save(company);
    }


    public Place getPlaceById(Long id) {
        Optional<Place> company = companyRepository.findById(id);
        return company.get();
    }
}
