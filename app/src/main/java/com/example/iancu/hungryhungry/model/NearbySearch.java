package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Iancu on 02/11/2016.
 */

public class NearbySearch extends RealmObject{
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("popularity")
    @Expose
    private Popularity popularity;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("nearby_restaurants")
    @Expose
    private RealmList<NearbyRestaurant> nearbyRestaurants = new RealmList<>();

    /**
     *
     * @return
     * The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     *
     * @param location
     * The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     *
     * @return
     * The popularity
     */
    public Popularity getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The nearbyRestaurants
     */
    public List<NearbyRestaurant> getNearbyRestaurants() {
        return nearbyRestaurants;
    }

    /**
     *
     * @param nearbyRestaurants
     * The nearby_restaurants
     */
    public void setNearbyRestaurants(RealmList<NearbyRestaurant> nearbyRestaurants) {
        this.nearbyRestaurants = nearbyRestaurants;
    }

}

