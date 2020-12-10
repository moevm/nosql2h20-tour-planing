package com.nosql2h20.tourplaning.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class NewPlaceDTO {
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String imageUrl;
    @Getter @Setter private double latitude;
    @Getter @Setter private double longitude;
    @Getter @Setter private String address;
    @Getter @Setter private HashMap<Long, NewPathDTO> paths;
}
