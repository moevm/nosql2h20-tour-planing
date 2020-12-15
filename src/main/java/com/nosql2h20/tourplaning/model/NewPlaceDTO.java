package com.nosql2h20.tourplaning.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class NewPlaceDTO {
    private String name;
    private String description;
    private String imageUrl;
    private double latitude;
    private double longitude;
    private String address;
    private HashMap<Long, NewPathDTO> paths;
}
