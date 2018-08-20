package com.fui.viewpager.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

public class SubTypeAdapter extends TypeAdapter {
    public SubTypeAdapter(Activity activity, FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(activity, fm, fragments, titles);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
