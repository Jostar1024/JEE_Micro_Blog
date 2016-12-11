package com.caoych;

import com.caoych.db.PeopleRepository;
import com.caoych.db.Tweets;
import com.caoych.db.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by caoych on 2016/12/11.
 */
@RestController
public class HashtagController {
    @Autowired
    private PeopleRepository pRepo;
    @Autowired
    private TweetsRepository tRepo;

    @RequestMapping("/hashtag")
    public List<Tweets> getTweetsByHashtag(@RequestParam(value = "hashtag", defaultValue="") String hashtag) {
        //TODO : return the value to the hashtag.html to get a better view.
        return tRepo.findByHashTag(hashtag);
    }
}
