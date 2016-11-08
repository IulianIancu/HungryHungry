package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Iancu on 08/11/2016.
 */

public class ReviewSearch  extends RealmObject{
    @SerializedName("reviews_count")
    @Expose
    private Integer reviewsCount;
    @SerializedName("reviews_start")
    @Expose
    private Integer reviewsStart;
    @SerializedName("reviews_shown")
    @Expose
    private Integer reviewsShown;
    @SerializedName("user_reviews")
    @Expose
    private RealmList<UserReview> userReviews = new RealmList<>();
    /**
     *
     * @return
     * The reviewsCount
     */
    public Integer getReviewsCount() {
        return reviewsCount;
    }

    /**
     *
     * @param reviewsCount
     * The reviews_count
     */
    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    /**
     *
     * @return
     * The reviewsStart
     */
    public Integer getReviewsStart() {
        return reviewsStart;
    }

    /**
     *
     * @param reviewsStart
     * The reviews_start
     */
    public void setReviewsStart(Integer reviewsStart) {
        this.reviewsStart = reviewsStart;
    }

    /**
     *
     * @return
     * The reviewsShown
     */
    public Integer getReviewsShown() {
        return reviewsShown;
    }

    /**
     *
     * @param reviewsShown
     * The reviews_shown
     */
    public void setReviewsShown(Integer reviewsShown) {
        this.reviewsShown = reviewsShown;
    }

    /**
     *
     * @return
     * The userReviews
     */
    public List<UserReview> getUserReviews() {
        return userReviews;
    }

    /**
     *
     * @param userReviews
     * The user_reviews
     */
    public void setUserReviews(RealmList<UserReview> userReviews) {
        this.userReviews = userReviews;
    }

}

