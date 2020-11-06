package com.nosql2h20.tourplaning.entity.neo4j;

import com.nosql2h20.tourplaning.model.dto.PlaceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NodeEntity("Place")
public class PlaceNeo4j {

    @Id
    @GeneratedValue
    Long id;

    private String name;

    public PlaceNeo4j(PlaceDTO placeDTO) {
        this.name = placeDTO.getName();
    }
}
