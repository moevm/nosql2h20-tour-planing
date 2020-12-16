package com.nosql2h20.tourplaning.entity;

import lombok.*;
import org.neo4j.ogm.annotation.*;

@Data
@Getter @Setter
@RelationshipEntity(type = "path")
public class Path {
    public Path(String name, double distance, Place firstPlace, Place secondPlace) {
        this.name = name;
        this.distance = distance;
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
    }

    @Id @GeneratedValue private Long id;
    private String name;
    private double distance;

    @StartNode private Place firstPlace;
    @EndNode private Place secondPlace;
}
