package com.pangan.pagingtest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagingRepository extends MongoRepository<PagingObject, String> {
}
