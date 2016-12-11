package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by caoych on 2016/12/11.
 */
@Controller
public class CreateProfileController {

    @Autowired
    private PeopleRepository pRepo;

    @GetMapping("/create_profile")
    public String creteProfileForm(Model model) {
        model.addAttribute("people", new People());
        return "create_profile";
    }
    @PostMapping("/create_profile")
    public String createProfileSubmit(@ModelAttribute People people) {
        pRepo.save(people);
        return "login";
    }
}
