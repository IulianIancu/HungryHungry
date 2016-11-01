package com.example.iancu.hungryhungry.connection;

import com.example.iancu.hungryhungry.model.RestaurantCategory;

import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by Iancu on 01/11/2016.
 */

public interface ZomatoAPI {
    @GET("/api/v2.1/categories")
    Observable<RestaurantCategory> getCategories();
}
