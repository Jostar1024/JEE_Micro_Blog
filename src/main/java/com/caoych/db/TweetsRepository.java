package com.caoych.db;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by caoych on 2016/12/10.
 */
public interface TweetsRepository extends MongoRepository<Tweets, String> {
    List<Tweets> findById(String id);
    List<Tweets> findByHashTag(String hashTag);
}
