package com.example.iancu.hungryhungry.presenter;

import android.util.Log;

import com.example.iancu.hungryhungry.connection.ConnectionService;
import com.example.iancu.hungryhungry.connection.ZomatoAPI;
import com.example.iancu.hungryhungry.interfaces.MainActivityIntf;
import com.example.iancu.hungryhungry.model.Category;
import com.example.iancu.hungryhungry.model.RestaurantCategory;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Iancu on 01/11/2016.
 */

public class TestPresenterImpl extends TestPresenter {
    ZomatoAPI api;
    MainActivityIntf intf;
    private CompositeSubscription subscription = new CompositeSubscription();
    private final String key ="e2acaf6951ba81be0294f4254763b7f6";


    public TestPresenterImpl(MainActivityIntf intf){
        this.intf = intf;
    }
    @Override
    public void getCats() {
        String temp ="WROONG";
        api = ConnectionService.getConnectionService();
        subscription.add(api.getCategories(temp)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RestaurantCategory>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("ERR", e.toString());
            }

            @Override
            public void onNext(RestaurantCategory restaurantCategory) {
                List<Category> categories =restaurantCategory.getCategories();
                intf.getCategories(categories);
            }
        }));
    }
}
