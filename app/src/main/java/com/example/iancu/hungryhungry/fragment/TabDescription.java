package com.example.iancu.hungryhungry.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iancu.hungryhungry.R;
import com.example.iancu.hungryhungry.adapter.ImageSlideAdapter;
import com.example.iancu.hungryhungry.model.NearbyRestaurant;
import com.example.iancu.hungryhungry.model.NearbySearch;
import com.example.iancu.hungryhungry.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmQuery;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabDescription extends Fragment {
    @BindView(R.id.image_recy)
    RecyclerView imageRecy;
    @BindView(R.id.rest_name)
    TextView name;
    @BindView(R.id.rest_location)
    TextView location;
    @BindView(R.id.rest_price)
    TextView price;
    @BindView(R.id.rest_rating)
    TextView rating;
    @BindView(R.id.rest_score)
    TextView score;
    Restaurant restaurant;


    public TabDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_tab_description, container, false);
        ButterKnife.bind(this,v);
//        List<String> temps =new ArrayList<>();
//        Realm.init(container.getContext());
//        Realm realm = Realm.getDefaultInstance();
//        RealmQuery<NearbySearch> categQuery =realm.where(NearbySearch.class);
//        NearbySearch realmResult= categQuery.findFirst();
//        List<NearbyRestaurant> rests =realmResult.getNearbyRestaurants();
//        temps.add(rests.get(0).getRestaurant().getThumb());
//        temps.add(rests.get(0).getRestaurant().getThumb());

        List<String> temps =new ArrayList<>();
        temps.add(restaurant.getFeaturedImage());
        temps.add(restaurant.getThumb());

        imageRecy.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.HORIZONTAL,false));
        imageRecy.setAdapter(new ImageSlideAdapter(temps,R.layout.recycler_image_pane,container.getContext()));

        name.setText(restaurant.getName());
        location.setText(restaurant.getLocation().getAddress());
        price.setText(restaurant.getAverageCostForTwo()+ restaurant.getCurrency());
        rating.setText(restaurant.getUserRating().getRatingText()+" ("+restaurant.getUserRating().getVotes()+" users)");
        score.setText(restaurant.getUserRating().getAggregateRating());




        return v ;
    }

    /**
     * This method is supposed to take the given restaurant
     * @param r is the Restaurant object
     */
    public void setRestaurant(Restaurant r){
        this.restaurant =r;

    }

}
