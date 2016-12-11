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

    public People people;

    public Tweets() {}
    public Tweets(String content, String date, String[] hashTag, String personId) {
        this.content = content;
        this.date = date;
        this.hashTag = hashTag;
        this.personId = personId;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDate() {
        return this.date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String[] getHashTag() {
        return this.hashTag;
    }
    public void setHashTag(String[] hashTag) {
        this.hashTag = hashTag;
    }
    public String getPersonId() {
        return this.personId;
    }
    public void setPersonId(String personId){
        this.personId = personId;
    }
    public People getPeople() {
        return people;
    }
    public void setPeople(People p) {
        this.people = p;
    }
    @Override
    public String toString() {
        return String.format(
                "Tweet : [id = %s, content = %s, date = %s, hashTag = %s, personId = %s",
                id, content, date, Arrays.toString(hashTag), personId
        );
    }


}
