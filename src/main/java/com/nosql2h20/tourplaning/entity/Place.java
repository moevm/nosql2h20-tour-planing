package com.nosql2h20.tourplaning.entity;

import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.UNDIRECTED;

@Data
@NodeEntity
public class Place {
    public Place(String name, String description, String imageUrl, double latitude, double longitude, String address) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    @Getter @Setter @Id @GeneratedValue private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String description;
    @Getter @Setter private String imageUrl;
    @Getter @Setter private double latitude;
    @Getter @Setter private double longitude;
    @Getter @Setter private String address;

    @Relationship(type = "path", direction = UNDIRECTED)
    private List<Place> places = new ArrayList<>();
}
