package com.caoych.db;


import org.springframework.data.annotation.Id;

import java.util.Arrays;

/**
 * Created by caoych on 2016/12/10.
 */
public class Tweets {
    @Id
    public String id;

    public String content;
    public String date;
    public String[] hashTag;
    public String personId;

    public People p;

    public Tweets(String content, String date, String[] hashTag, String personId) {
        this.content = content;
        this.date = date;
        this.hashTag = hashTag;
        this.personId = personId;
    }
    public People getPeople() {
        return p;
    }
    public void setPeople(People p) {
        this.p = p;
    }
    @Override
    public String toString() {
        return String.format(
                "Tweet : [id = %s, content = %s, date = %s, hashTag = %s",
                id, content, date, Arrays.toString(hashTag)
        );
    }


}
