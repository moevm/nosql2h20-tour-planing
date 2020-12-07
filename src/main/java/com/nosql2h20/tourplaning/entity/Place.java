package com.nosql2h20.tourplaning.entity;

import lombok.*;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity("Place")
public class Place {
    public Place(String name, String description, String imageUrl, double latitude, double longitude, String address) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.id = UUID.randomUUID();
    }

    @Getter @Setter private UUID id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String imageUrl;
    @Getter @Setter private double latitude;
    @Getter @Setter private double longitude;
    @Getter @Setter private String address;
}
