package com.example.iancu.hungryhungry.presenter;

import android.location.Location;

/**
 * Created by Iancu on 01/11/2016.
 */

public abstract class TestPresenter {
    public abstract void getCats();
    public abstract void getNearbyRes(Location location);
}
