package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by caoych on 2016/12/10.
 */
@SpringBootApplication
public class Application {

    @Autowired
    private PeopleRepository pRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @RequestMapping("/")
//    public void visit(Model model) {
//        pRepo.deleteAll();
//        model.addAttribute("name2", "caoych");
//    }
}
