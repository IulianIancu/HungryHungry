package com.example.iancu.hungryhungry.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Iancu on 01/11/2016.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumbOfTabs;
    public ViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabs) {
        super(fm);
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        TabDescription r =new TabDescription();
        return r;
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
