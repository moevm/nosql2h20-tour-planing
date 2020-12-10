package com.nosql2h20.tourplaning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PathDTO {
    @Getter @Setter private Long id;
    @Getter @Setter private Long start;
    @Getter @Setter private Long end;
    @Getter @Setter private String type;
    @Getter @Setter private String name;
    @Getter @Setter private double distance;
}

