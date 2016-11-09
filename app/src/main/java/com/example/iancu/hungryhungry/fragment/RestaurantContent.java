package com.example.iancu.hungryhungry.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iancu.hungryhungry.R;
import com.example.iancu.hungryhungry.adapter.ViewPagerAdapter;
import com.example.iancu.hungryhungry.model.Restaurant;
import com.example.iancu.hungryhungry.model.ReviewSearch;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RestaurantContent.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class RestaurantContent extends Fragment {

    private OnFragmentInteractionListener mListener;
    @BindView(R.id.restaurant_pager)
    ViewPager pager;
    ViewPagerAdapter adapter;
    Restaurant restaurant;
    ReviewSearch reviewSearch;
    CharSequence titles[]={"Description","Map","Reviews"};
    int numboftabs =3;


    public RestaurantContent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_restaurant_content, container, false);
        ButterKnife.bind(this,v);
        adapter =new ViewPagerAdapter(getFragmentManager(),titles,numboftabs,restaurant,reviewSearch);
        pager.setAdapter(adapter);

        return v ;
    }

    public void setTheRestaurant(Restaurant restaurant){
        this.restaurant =restaurant;

    }
    public void setReviews(ReviewSearch reviews){
        this.reviewSearch =reviews;
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
        void onFragmentInteraction();
    }
}
