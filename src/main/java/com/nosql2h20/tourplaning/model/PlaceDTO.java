package com.nosql2h20.tourplaning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter @Setter
public class PlaceDTO {

    public PlaceDTO(Long id, String name, String description, String imageUrl, double latitude, double longitude, String address, List<Long> connectedPlaces) {
        this(id, name, description, imageUrl, latitude, longitude, address);
        this.connectedPlaceIds = connectedPlaces;
    }

    public PlaceDTO(Long id, String name, String description, String imageUrl, double latitude, double longitude, String address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private double latitude;
    private double longitude;
    private String address;

    private List<Long> connectedPlaceIds;
}
