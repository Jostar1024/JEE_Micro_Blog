package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import com.caoych.db.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caoych on 2016/12/10.
 */
@Controller
public class IndexController {

    @Autowired
    private PeopleRepository pRepo;

    @Autowired
    private TweetsRepository tRepo;

    @RequestMapping("/index")
    public  String index(String name, Model model) {
        init_db();
        People p = pRepo.findByFirstName("Amy");

        model.addAttribute("name", p.firstName);

        return "index";
    }
    private void init_db() {
        pRepo.save(new People("Amy", "A"));
    }
}
