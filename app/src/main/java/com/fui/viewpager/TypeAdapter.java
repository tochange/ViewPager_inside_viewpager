package com.fui.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TypeAdapter extends FragmentPagerAdapter {
    private final String[] mTitles;
    private List<Fragment> fragments;

    public TypeAdapter(FragmentManager fm,
                       List<Fragment> fragments,
                       String[] titles) {
        super(fm);
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
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
