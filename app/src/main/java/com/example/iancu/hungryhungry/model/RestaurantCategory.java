package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Iancu on 01/11/2016.
 */

public class RestaurantCategory extends RealmObject {
    @SerializedName("categories")
    @Expose
    private RealmList<Category> categories = new RealmList<Category>();

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
    public void setCategories(RealmList<Category> categories) {
        this.categories = categories;
    }
}

