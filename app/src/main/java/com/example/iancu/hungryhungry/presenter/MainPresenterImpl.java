package com.example.iancu.hungryhungry.presenter;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.example.iancu.hungryhungry.connection.ConnectionService;
import com.example.iancu.hungryhungry.connection.ZomatoAPI;
import com.example.iancu.hungryhungry.interfaces.MainActivityIntf;
import com.example.iancu.hungryhungry.model.Category;
import com.example.iancu.hungryhungry.model.NearbySearch;
import com.example.iancu.hungryhungry.model.RestaurantCategory;
import com.github.pwittchen.reactivenetwork.library.ReactiveNetwork;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Iancu on 01/11/2016.
 */

public class MainPresenterImpl extends MainPresenter {
    ZomatoAPI api;
    MainActivityIntf intf;
    private CompositeSubscription subscription = new CompositeSubscription();
    private final String key1 = "e2acaf6951ba81be0294f4254763b7f6";
    private final String key2 = "599492016b657b2b342267e50038ca98";


    public MainPresenterImpl(MainActivityIntf intf) {
        this.intf = intf;
    }

    /**
     * Returns the categories of food available to the user.
     */
    @Override
    public void getCats(final Context context) {

        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean isConnectedToInternet) {
                        // do something with isConnectedToInternet value
                        if (isConnectedToInternet) getCatsFromServer(context);
                        else getCatsFromDB(context);
                    }
                });




    }
    public void getCatsFromServer(Context context){
        Realm.init(context);
        final Realm realm =Realm.getDefaultInstance();
        api = ConnectionService.getConnectionService();
        subscription.add(api.getCategories(key1)
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
                        List<Category> categories = restaurantCategory.getCategories();
                        realm.beginTransaction();
                        realm.deleteAll();
                        realm.copyToRealm(restaurantCategory);
                        realm.commitTransaction();
                        intf.recieveCategories(categories);
                        realm.close();
                    }
                }));
    }

    public void getCatsFromDB(Context context){
        Realm.init(context);
        Realm realm =Realm.getDefaultInstance();
        RealmQuery<RestaurantCategory> categQuery =realm.where(RestaurantCategory.class);
        RestaurantCategory RealmResult= categQuery.findFirst();
        List<Category> categories =RealmResult.getCategories();
        intf.recieveCategories(categories);
        realm.close();




    }


    @Override
    public void getNearbyRes(Location location) {

        api = ConnectionService.getConnectionService();
        subscription.add(api.getNearbyRes(key1, location.getLatitude(), location.getLongitude())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NearbySearch>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERR", e.toString());
                    }

                    @Override
                    public void onNext(NearbySearch nearbySearch) {
                        intf.recieveRestaurants(nearbySearch.getNearbyRestaurants());
                    }
                }));
    }
}
