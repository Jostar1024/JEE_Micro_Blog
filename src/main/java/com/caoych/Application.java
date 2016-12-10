package com.caoych;

import com.caoych.db.People;
import com.caoych.db.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by caoych on 2016/12/10.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//
//        repo.deleteAll();
//
//        repo.save(new People("Amy","A"));
//        repo.save(new People("Bob", "B"));
//
//        // fetch all customers
//        System.out.println("Customers found with findAll():");
//        System.out.println("-------------------------------");
//        for (People p : repo.findAll()) {
//            System.out.println(p);
//        }
//        System.out.println();
//
//        // fetch an individual customer
//        System.out.println("Customer found with findByFirstName('Alice'):");
//        System.out.println("--------------------------------");
//        System.out.println(repo.findByFirstName("Amy"));
//
//        System.out.println("Customers found with findByLastName('Smith'):");
//        System.out.println("--------------------------------");
//        for (People p : repo.findByLastName("B")) {
//            System.out.println(p);
//        }
//    }
}
