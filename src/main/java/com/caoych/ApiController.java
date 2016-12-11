package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import com.caoych.db.Tweets;
import com.caoych.db.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by caoych on 2016/12/11.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private PeopleRepository pRepo;

    @Autowired
    private TweetsRepository tRepo;

    @RequestMapping("/people/{firstName}")
    public People getPeople(@PathVariable String firstName) {
        return pRepo.findByFirstName(firstName);
    }

    @RequestMapping("/tweets/{hashTag}")
    public List<Tweets> getTweet(@PathVariable String hashTag) {
        return tRepo.findByHashTag(hashTag);
    }
}
