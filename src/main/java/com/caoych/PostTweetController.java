package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import com.caoych.db.Tweets;
import com.caoych.db.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caoych on 2016/12/11.
 */
@Controller
public class PostTweetController {
    @Autowired
    private TweetsRepository tRepo;

    @Autowired
    private PeopleRepository pRepo;

    @GetMapping("/post_tweet")
    public String createTweet(Principal principal, Model model) {
        String firstName = "";
        if (principal != null) {
            model.addAttribute("principal", principal.getName());
            firstName = principal.getName();
        }
        Tweets post_message= new Tweets();
//        post_message.setPersonId(pRepo.findByFirstName(firstName).id);
        model.addAttribute("post_message", post_message);
        return "post_tweet";
    }

    @PostMapping("/post_tweet")
    public String postTweet(@ModelAttribute("post_message") Tweets post_message, @ModelAttribute("principal") String firstName) {

        post_message.setHashTag(new String[] {"new"});
        post_message.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        tRepo.save(post_message);
        System.out.println(post_message.toString());
        return "post_tweet";
    }
}
