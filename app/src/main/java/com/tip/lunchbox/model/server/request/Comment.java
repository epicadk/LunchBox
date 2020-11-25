package com.tip.lunchbox.model.server.request;

import com.google.gson.annotations.Expose;

public class Comment {
    @Expose
    private String comment;
    @Expose
    private int rating;
    @Expose
    private int zomato_res_id;

    public Comment(String comment, int rating, String zomato_res_id) {
        this.comment = comment;
        this.rating = rating;
        this.zomato_res_id = Integer.parseInt(zomato_res_id);
    }

    public String getComment() {
        return comment;
    }


    public int getRating() {
        return rating;
    }


    public String getZomatoResId() {
        return "" + zomato_res_id;
    }

}
