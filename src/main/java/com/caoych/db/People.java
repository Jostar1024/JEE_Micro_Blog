package com.caoych.db;

import org.springframework.data.annotation.Id;

/**
 * Created by caoych on 2016/12/10.
 */
public class People {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    public People() {}

    public People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "People [id = %s, first name = %s, last name = %s",
                id, firstName, lastName);
    }
}
