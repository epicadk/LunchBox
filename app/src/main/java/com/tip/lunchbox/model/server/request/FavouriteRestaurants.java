package com.tip.lunchbox.model.server.request;

public class FavouriteRestaurants {

    private int zomato_res_id;

    public String getZomatoResId() {
        return "" + zomato_res_id;
    }

    public void setZomatoResId(int zomato_res_id) {
        this.zomato_res_id = zomato_res_id;
    }
}
