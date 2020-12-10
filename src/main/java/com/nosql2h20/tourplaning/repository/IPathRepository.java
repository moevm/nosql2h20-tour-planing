package com.nosql2h20.tourplaning.repository;

import com.nosql2h20.tourplaning.entity.Path;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPathRepository extends Neo4jRepository<Path, Long> {
}
