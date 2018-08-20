package com.fui.viewpager.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public abstract class TypeAdapter extends FragmentPagerAdapter {
    protected final String[] mTitles;
    protected List<Fragment> fragments;
    protected Activity activity;

    public TypeAdapter(Activity activity,
                       FragmentManager fm,
                       List<Fragment> fragments,
                       String[] titles) {
        super(fm);
        this.activity = activity;
        this.fragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public abstract CharSequence getPageTitle(int position);
}
