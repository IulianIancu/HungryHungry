package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class NearbyRestaurant extends RealmObject{

    @SerializedName("restaurant")
    @Expose
    private Restaurant restaurant;

    /**
     *
     * @return
     * The restaurant
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     *
     * @param restaurant
     * The restaurant
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
