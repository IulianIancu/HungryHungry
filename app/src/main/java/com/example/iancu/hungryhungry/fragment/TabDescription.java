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

    public TabDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_tab_description, container, false);
        ButterKnife.bind(this,v);
        imageRecy.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.HORIZONTAL,false));
        List<String> temps =new ArrayList<>();
        Realm.init(container.getContext());
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<NearbySearch> categQuery =realm.where(NearbySearch.class);
        NearbySearch realmResult= categQuery.findFirst();
        List<NearbyRestaurant> rests =realmResult.getNearbyRestaurants();
        temps.add(rests.get(0).getRestaurant().getThumb());
        temps.add(rests.get(0).getRestaurant().getThumb());
        imageRecy.setAdapter(new ImageSlideAdapter(temps,R.layout.recycler_image_pane,container.getContext()));
        name.setText(rests.get(0).getRestaurant().getName());
        location.setText(rests.get(0).getRestaurant().getLocation().getAddress());
        price.setText(rests.get(0).getRestaurant().getAverageCostForTwo()+
                        rests.get(0).getRestaurant().getCurrency());
        rating.setText(rests.get(0).getRestaurant().getUserRating().getRatingText());
        score.setText(rests.get(0).getRestaurant().getUserRating().getAggregateRating());




        return v ;
    }

}
