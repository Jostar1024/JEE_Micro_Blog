package com.caoych.controller;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import com.caoych.db.Tweets;
import com.caoych.db.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by caoych on 2016/12/11.
 */
@Controller
public class ProfileController {
    @Autowired
    private PeopleRepository pRepo;
    @Autowired
    private TweetsRepository tRepo;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getPe(String firstName) {
        People people = pRepo.findByFirstName(firstName);
        return "profile";
    }
//    public String getPeople(@RequestParam(value = "firstName", defaultValue="") String firstName) {
//        People people = pRepo.findByFirstName(firstName);
//        return "profile";
//    }
}
