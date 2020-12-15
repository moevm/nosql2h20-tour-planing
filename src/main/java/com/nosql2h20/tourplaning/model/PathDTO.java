package com.nosql2h20.tourplaning.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class PathDTO {
    private Long id;
    private Long start;
    private Long end;
    private String name;
    private double distance;
}

