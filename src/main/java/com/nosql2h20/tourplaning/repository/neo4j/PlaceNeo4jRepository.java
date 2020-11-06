package com.nosql2h20.tourplaning.repository.neo4j;

import com.nosql2h20.tourplaning.entity.neo4j.PlaceNeo4j;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceNeo4jRepository extends Neo4jRepository<PlaceNeo4j, Long> {

}
