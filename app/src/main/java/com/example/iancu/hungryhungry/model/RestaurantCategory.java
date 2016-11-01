package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iancu on 01/11/2016.
 */

public class RestaurantCategory {
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();

    /**
     *
     * @return
     * The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}

