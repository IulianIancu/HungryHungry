package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Review extends RealmObject{

    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("review_text")
    @Expose
    private String reviewText;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("rating_color")
    @Expose
    private String ratingColor;
    @SerializedName("review_time_friendly")
    @Expose
    private String reviewTimeFriendly;
    @SerializedName("rating_text")
    @Expose
    private String ratingText;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;

    /**
     *
     * @return
     * The rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The reviewText
     */
    public String getReviewText() {
        return reviewText;
    }

    /**
     *
     * @param reviewText
     * The review_text
     */
    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The ratingColor
     */
    public String getRatingColor() {
        return ratingColor;
    }

    /**
     *
     * @param ratingColor
     * The rating_color
     */
    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    /**
     *
     * @return
     * The reviewTimeFriendly
     */
    public String getReviewTimeFriendly() {
        return reviewTimeFriendly;
    }

    /**
     *
     * @param reviewTimeFriendly
     * The review_time_friendly
     */
    public void setReviewTimeFriendly(String reviewTimeFriendly) {
        this.reviewTimeFriendly = reviewTimeFriendly;
    }

    /**
     *
     * @return
     * The ratingText
     */
    public String getRatingText() {
        return ratingText;
    }

    /**
     *
     * @param ratingText
     * The rating_text
     */
    public void setRatingText(String ratingText) {
        this.ratingText = ratingText;
    }

    /**
     *
     * @return
     * The timestamp
     */
    public Integer getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     * The timestamp
     */
    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     * @return
     * The likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     * The likes
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The commentsCount
     */
    public Integer getCommentsCount() {
        return commentsCount;
    }

    /**
     *
     * @param commentsCount
     * The comments_count
     */
    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

}
