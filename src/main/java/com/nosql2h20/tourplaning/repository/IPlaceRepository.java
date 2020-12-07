package com.nosql2h20.tourplaning.repository;

import com.nosql2h20.tourplaning.entity.Place;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceRepository extends Neo4jRepository<Place, Long> {

}
