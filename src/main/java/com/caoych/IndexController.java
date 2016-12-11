package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import com.caoych.db.Tweets;
import com.caoych.db.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * Created by caoych on 2016/12/10.
 */
@Controller
public class IndexController {

    @Autowired
    private PeopleRepository pRepo;

    @Autowired
    private TweetsRepository tRepo;

    @RequestMapping("/")
    public  String index(String name, Model model) {
        init_db();
        List<Tweets> lt= tRepo.findAll();
        for ( Tweets t: lt) {
            People p = pRepo.findById(t.personId);
            t.setPeople(p);
        }
        model.addAttribute("tweets", lt);

        return "index";
    }
    private void init_db() {
        pRepo.deleteAll();
        tRepo.deleteAll();
        // init users.
        pRepo.save(new People("Albert", "Camus", "1234"));
        pRepo.save(new People("Simone", "Beauvoir", "1234"));
        pRepo.save(new People("Jean-Paul", "Sartre","1234"));
        pRepo.save(new People("Michel", "de Montaigne", "1234"));
        pRepo.save(new People("Honoré", "de Balzac", "1234"));
        pRepo.save(new People("Emile", "Zola", "1234"));

        // init tweets
        tRepo.save(new Tweets("This is a test tweets,",
                "2016-12-10",
                new String[]{"WhatASuperWonderfulDayWhichMakeTheHashTagAsLongAsJavaClassDefition"},
                pRepo.findByFirstName("Albert").id));

        tRepo.save(new Tweets("Ne marche pas devant moi, je ne suivrai peut-être pas.\n" +
                "Ne marche pas derrière moi, je ne te guiderai peut-être pas.\n" +
                "Marche juste à côté de moi et sois mon ami.",
                "2016-10-15 17:10:00",
                new String[]{"LesJuste"},
                pRepo.findByFirstName("Albert").id));

        tRepo.save(new Tweets("Se vouloir libre, c'est aussi vouloir les autres libres",
                "1972-04-26 10:13:00",
                new String[]{"Citation"},
                pRepo.findByFirstName("Simone").id));

        tRepo.save(new Tweets("Les objets sont ce qu'ils sont, l'homme n'est pas ce qu'il est, il est ce qu'il n'est pas.",
                "2016-10-13 17:15:00",
                new String[]{"Être en-soi et être pour-soi"},
                pRepo.findByFirstName("Jean-Paul").id));

        tRepo.save(new Tweets("je suis moi-même la matière de mon livre",
                "1570-10-13 17:15:00",
                new String[]{"Essais"},
                pRepo.findByFirstName("Michel").id));

        tRepo.save(new Tweets("J'accuse",
                "1898-01-13 17:15:00",
                new String[]{"L'Aurore"},
                pRepo.findByFirstName("Emile").id));

    }
}
