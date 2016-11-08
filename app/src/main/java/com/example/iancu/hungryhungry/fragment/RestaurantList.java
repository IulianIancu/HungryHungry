package com.example.iancu.hungryhungry.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iancu.hungryhungry.R;
import com.example.iancu.hungryhungry.adapter.RestaurantListAdapter;
import com.example.iancu.hungryhungry.model.NearbyRestaurant;
import com.example.iancu.hungryhungry.model.Restaurant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RestaurantList.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RestaurantList extends Fragment {

    private OnFragmentInteractionListener mListener;

    public RestaurantList() {
        // Required empty public constructor
    }

    @BindView(R.id.restaurant_list)
    RecyclerView restaurantList;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.pushy)
    TextView pushy;
    RestaurantListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_restaurant_list, container, false);
        ButterKnife.bind(this, v);
//        if(mListener != null)
//            mListener.onFragmentInteraction(1337);
        restaurantList.setLayoutManager(new LinearLayoutManager(v.getContext()));


//        Placeholder until i think of what to do with it
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh.setRefreshing(false);
            }
        });

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     * This function receives the clicked restaurant from the list and starts the display process for
     * its details
     *
     * @param r
     */
    public void clikedRest(Restaurant r) {
        if (r != null)
            mListener.onFragmentInteraction(r);


    }

    /**
     * This function is used by the activity to affect the fragment
     *
     * @param rests
     */
    public void setRestaurantList(List<NearbyRestaurant> rests) {
        if (rests == null) Log.e("OH NOES", "LIST IS DED");
        if (restaurantList == null) {
            Log.e("OH NOES", "RECYCLER IS DED");

            return;
        }
        adapter = new RestaurantListAdapter(rests, R.layout.recycler_rest_list_row, this);
        if (adapter == null) Log.e("OH NOES", "ADAPTER IS DED");
        restaurantList.setAdapter(adapter);
        pushy.setVisibility(View.GONE);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragment contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other fragment</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Restaurant restaurant);
    }
}
