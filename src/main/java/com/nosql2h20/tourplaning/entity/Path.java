package com.nosql2h20.tourplaning.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@Data
@RelationshipEntity(type = "path")
public class Path {
    public Path(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    @Getter @Setter @Id @GeneratedValue private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private double distance;

    @JsonIgnoreProperties("path")
    @StartNode @Getter @Setter private Place firstPlace;
    @JsonIgnoreProperties("path")
    @StartNode @Getter @Setter private Place secondPlace;
}
