package com.example.iancu.hungryhungry.interfaces;

import com.example.iancu.hungryhungry.model.Category;
import com.example.iancu.hungryhungry.model.NearbyRestaurant;
import com.example.iancu.hungryhungry.model.Restaurant;

import java.util.List;

/**
 * Created by Iancu on 01/11/2016.
 */

public interface MainActivityIntf {
    void recieveCategories(List<Category> cats);
    void recieveRestaurants(List<NearbyRestaurant> rests);
}
