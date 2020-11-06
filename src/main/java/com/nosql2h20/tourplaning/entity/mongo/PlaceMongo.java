package com.nosql2h20.tourplaning.entity.mongo;

import com.nosql2h20.tourplaning.model.dto.PlaceDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PlaceNeo4j")
public class PlaceMongo {

    @Id
    Long id;

    @Field("name")
    private String name;

    public PlaceMongo(PlaceDTO placeDTO) {
        this.id = placeDTO.getId();
        this.name = placeDTO.getName();
    }
}
