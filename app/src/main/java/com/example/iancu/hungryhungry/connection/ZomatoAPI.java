package com.example.iancu.hungryhungry.connection;

import com.example.iancu.hungryhungry.model.NearbySearch;
import com.example.iancu.hungryhungry.model.RestaurantCategory;
import com.example.iancu.hungryhungry.model.ReviewSearch;

import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

import retrofit2.http.GET;

/**
 * Created by Iancu on 01/11/2016.
 */

public interface ZomatoAPI {
    @GET("/api/v2.1/categories")
    Observable<RestaurantCategory> getCategories(@Header("user-key") String key);

    @GET("/api/v2.1/geocode")
    Observable<NearbySearch> getNearbyRes(@Header("user-key") String key, @Query("lat") Double lat,
                                          @Query("lon") Double lon);

    @GET("/api/v2.1/reviews")
    Observable<ReviewSearch> getReviews(@Header("user-key") String key, @Query("res_id") int resID,
                                        @Query("start") int start, @Query("count") int count);

}
