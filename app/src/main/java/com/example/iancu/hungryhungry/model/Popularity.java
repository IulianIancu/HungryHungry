package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Popularity {

    @SerializedName("popularity")
    @Expose
    private String popularity;
    @SerializedName("nightlife_index")
    @Expose
    private String nightlifeIndex;
    @SerializedName("nearby_res")
    @Expose
    private List<String> nearbyRes = new ArrayList<String>();
    @SerializedName("top_cuisines")
    @Expose
    private List<String> topCuisines = new ArrayList<String>();
    @SerializedName("popularity_res")
    @Expose
    private String popularityRes;
    @SerializedName("nightlife_res")
    @Expose
    private String nightlifeRes;
    @SerializedName("subzone")
    @Expose
    private String subzone;
    @SerializedName("subzone_id")
    @Expose
    private Integer subzoneId;
    @SerializedName("city")
    @Expose
    private String city;

    /**
     *
     * @return
     * The popularity
     */
    public String getPopularity() {
        return popularity;
    }

    /**
     *
     * @param popularity
     * The popularity
     */
    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    /**
     *
     * @return
     * The nightlifeIndex
     */
    public String getNightlifeIndex() {
        return nightlifeIndex;
    }

    /**
     *
     * @param nightlifeIndex
     * The nightlife_index
     */
    public void setNightlifeIndex(String nightlifeIndex) {
        this.nightlifeIndex = nightlifeIndex;
    }

    /**
     *
     * @return
     * The nearbyRes
     */
    public List<String> getNearbyRes() {
        return nearbyRes;
    }

    /**
     *
     * @param nearbyRes
     * The nearby_res
     */
    public void setNearbyRes(List<String> nearbyRes) {
        this.nearbyRes = nearbyRes;
    }

    /**
     *
     * @return
     * The topCuisines
     */
    public List<String> getTopCuisines() {
        return topCuisines;
    }

    /**
     *
     * @param topCuisines
     * The top_cuisines
     */
    public void setTopCuisines(List<String> topCuisines) {
        this.topCuisines = topCuisines;
    }

    /**
     *
     * @return
     * The popularityRes
     */
    public String getPopularityRes() {
        return popularityRes;
    }

    /**
     *
     * @param popularityRes
     * The popularity_res
     */
    public void setPopularityRes(String popularityRes) {
        this.popularityRes = popularityRes;
    }

    /**
     *
     * @return
     * The nightlifeRes
     */
    public String getNightlifeRes() {
        return nightlifeRes;
    }

    /**
     *
     * @param nightlifeRes
     * The nightlife_res
     */
    public void setNightlifeRes(String nightlifeRes) {
        this.nightlifeRes = nightlifeRes;
    }

    /**
     *
     * @return
     * The subzone
     */
    public String getSubzone() {
        return subzone;
    }

    /**
     *
     * @param subzone
     * The subzone
     */
    public void setSubzone(String subzone) {
        this.subzone = subzone;
    }

    /**
     *
     * @return
     * The subzoneId
     */
    public Integer getSubzoneId() {
        return subzoneId;
    }

    /**
     *
     * @param subzoneId
     * The subzone_id
     */
    public void setSubzoneId(Integer subzoneId) {
        this.subzoneId = subzoneId;
    }

    /**
     *
     * @return
     * The city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(String city) {
        this.city = city;
    }

}
