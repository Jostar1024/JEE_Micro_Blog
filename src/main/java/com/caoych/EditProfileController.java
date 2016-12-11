package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by caoych on 2016/12/11.
 */
@Controller
public class EditProfileController {
    @Autowired
    private PeopleRepository pRepo;
    private MongoOperations mongoOperations;

    // TODO : The controller isn't working as expected.
    @GetMapping("/edit_profile")
    public String creteProfileForm(@RequestParam(value = "firstName", defaultValue="") String firstName, Model model) {
        People people = pRepo.findByFirstName(firstName);
        model.addAttribute("people", people);
        return "edit_profile";
    }
    @PostMapping("/edit_profile")
    public String modifyExistingProfile(@ModelAttribute People people) {
        mongoOperations.updateFirst(
                new Query(Criteria.where("firstName").is(people.getFirstName())),
                Update.update("lastName", people.getLastName()), People.class);
        mongoOperations.updateFirst(
                new Query(Criteria.where("firstName").is(people.getFirstName())),
                Update.update("passwd", people.getPasswd()), People.class);
        return "index";
    }
}
