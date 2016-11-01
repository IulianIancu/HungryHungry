package com.example.iancu.hungryhungry.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iancu.hungryhungry.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabDescription extends Fragment {


    public TabDescription() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_tab_description, container, false);

        return v ;
    }

}
