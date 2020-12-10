package com.nosql2h20.tourplaning.model;

import lombok.Getter;
import lombok.Setter;

public class NewPathDTO {
    @Getter @Setter private String type;
    @Getter @Setter private String name;
    @Getter @Setter private double distance;
}
