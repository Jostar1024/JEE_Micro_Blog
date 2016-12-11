package com.caoych.db;

import org.springframework.data.annotation.Id;

/**
 * Created by caoych on 2016/12/10.
 */
public class People {
    @Id
    public String id;

    private String firstName;
    private String lastName;

    private String passwd;

    public People() {}

    public People(String firstName, String lastName, String passwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwd = passwd;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String new_firstName) {
        this.firstName = new_firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String new_lastName) {
        this.lastName = new_lastName;
    }
    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String new_passwd){
        this.passwd = new_passwd;
    }

    @Override
    public String toString() {
        return String.format(
                "People [id = %s, first name = %s, last name = %s",
                id, firstName, lastName);
    }
}
