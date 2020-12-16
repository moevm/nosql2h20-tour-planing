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
@Getter @Setter
public class Place {
    public Place(String name, String description, String imageUrl, double latitude, double longitude, String address) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    @Id @GeneratedValue private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private double latitude;
    private double longitude;
    private String address;

    @Relationship(type = "path", direction = UNDIRECTED)
    private List<Place> places = new ArrayList<>();
}
