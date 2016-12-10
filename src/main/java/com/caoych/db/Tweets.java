package com.caoych.db;


import org.springframework.data.annotation.Id;

/**
 * Created by caoych on 2016/12/10.
 */
public class Tweets {
    @Id
    public String id;

    public String content;
    public String date;
    public String hashTag;

    @Override
    public String toString() {
        return String.format(
                "Tweet : [id = %s, content = %s, date = %s, hashTag = %s",
                id, content, date, hashTag
        );
    }


}
