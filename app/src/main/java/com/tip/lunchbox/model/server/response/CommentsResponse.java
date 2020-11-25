package com.tip.lunchbox.model.server.response;

import com.squareup.moshi.Json;

// Required for Moshi
@SuppressWarnings("unused")
public class CommentsResponse {
    @Json(name = "_id")
    private String id;
    private Integer rating;
    private String comment;
    private int zomato_res_id;
    @Json(name = "user_name")
    private String author;

    public String getId() {
        return id;
    }

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public int getZomatoResId() {
        return zomato_res_id;
    }

    public String getAuthor() {
        return author;
    }
}
