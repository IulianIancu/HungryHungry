package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Category extends RealmObject {

    @SerializedName("categories")
    @Expose
    private Categories categories;

    /**
     *
     * @return
     * The categories
     */
    public Categories getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(Categories categories) {
        this.categories = categories;
    }

}
