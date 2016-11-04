package com.example.iancu.hungryhungry.presenter;

import android.content.Context;
import android.location.Location;

/**
 * Created by Iancu on 01/11/2016.
 */

public abstract class MainPresenter {
    public abstract void getCats(Context context);
    public abstract void getNearbyRes(Location location);
}
