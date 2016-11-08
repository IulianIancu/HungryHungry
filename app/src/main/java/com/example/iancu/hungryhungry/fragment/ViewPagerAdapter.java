package com.example.iancu.hungryhungry.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.iancu.hungryhungry.model.Restaurant;
import com.example.iancu.hungryhungry.model.ReviewSearch;

/**
 * Created by Iancu on 01/11/2016.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumbOfTabs;
    Restaurant restaurant;
    ReviewSearch reviewSearch;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabs,
                            Restaurant restaurant, ReviewSearch reviewSearch) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabs;
        this.restaurant = restaurant;
        this.reviewSearch = reviewSearch;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 2) {

            TabReviews r = new TabReviews();
            r.setReviews(reviewSearch);
            return r;
        } else {
            TabDescription r = new TabDescription();
            r.setRestaurant(restaurant);
            return r;
        }


    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
