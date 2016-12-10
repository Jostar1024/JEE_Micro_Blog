package com.caoych.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * Created by caoych on 2016/12/10.
 */
public interface PeopleRepository extends MongoRepository<People, String> {

    People findByFirstName(String firstName);
    List<People> findByLastName(String lastName);

}
