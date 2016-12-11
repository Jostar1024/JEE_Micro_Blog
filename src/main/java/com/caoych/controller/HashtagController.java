package com.caoych.controller;

import com.caoych.db.PeopleRepository;
import com.caoych.db.Tweets;
import com.caoych.db.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by caoych on 2016/12/11.
 */
@Controller
public class HashtagController {
    @Autowired
    private PeopleRepository pRepo;
    @Autowired
    private TweetsRepository tRepo;

    @RequestMapping(value = "/hashtag", method = RequestMethod.GET)
    public String getTweetsByHashtag(@RequestParam(value = "hashtag", defaultValue="") String hashtag, Model model) {
        List<Tweets> lt = tRepo.findByHashTag(hashtag);
        model.addAttribute("list_tweets_by_hashtag", lt);
        return "hashtag";
    }
}
