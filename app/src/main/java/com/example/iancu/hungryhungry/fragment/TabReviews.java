package com.example.iancu.hungryhungry.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.iancu.hungryhungry.R;
import com.example.iancu.hungryhungry.adapter.ReviewListAdapter;
import com.example.iancu.hungryhungry.model.ReviewSearch;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabReviews extends Fragment {
    @BindView(R.id.recy_review)
    RecyclerView recyclerView;
    ReviewSearch reviewSearch;


    public TabReviews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_reviews, container, false);
        ButterKnife.bind(this,v);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ReviewListAdapter(reviewSearch,container.getContext()));

        return v;

    }


    public void setReviews(ReviewSearch reviews){
        this.reviewSearch =reviews;
    }

}
