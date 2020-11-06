package com.nosql2h20.tourplaning.repository.mongo;


import com.nosql2h20.tourplaning.entity.mongo.PlaceMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceMongoRepository extends MongoRepository<PlaceMongo, Long> {
}
