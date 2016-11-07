package com.example.iancu.hungryhungry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class R extends RealmObject {

    @SerializedName("res_id")
    @Expose
    private Integer resId;

    /**
     *
     * @return
     * The resId
     */
    public Integer getResId() {
        return resId;
    }

    /**
     *
     * @param resId
     * The res_id
     */
    public void setResId(Integer resId) {
        this.resId = resId;
    }

}
