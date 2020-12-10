package com.nosql2h20.tourplaning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
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

    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String imageUrl;
    @Getter @Setter private double latitude;
    @Getter @Setter private double longitude;
    @Getter @Setter private String address;

    @Getter @Setter private List<Long> connectedPlaceIds;
}
