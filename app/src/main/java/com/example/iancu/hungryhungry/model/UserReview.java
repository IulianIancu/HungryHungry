package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class UserReview  extends RealmObject{

    @SerializedName("review")
    @Expose
    private Review review;

    /**
     *
     * @return
     * The review
     */
    public Review getReview() {
        return review;
    }

    /**
     *
     * @param review
     * The review
     */
    public void setReview(Review review) {
        this.review = review;
    }

}
