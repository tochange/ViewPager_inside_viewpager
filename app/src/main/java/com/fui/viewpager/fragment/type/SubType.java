package com.fui.viewpager.fragment.type;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;


import com.fui.viewpager.fragment.GridFragment;

import java.util.ArrayList;
import java.util.HashMap;


public class SubType extends TypeFragment {

    @Override
    FragmentManager getFragmentManager(FragmentActivity activity) {
        return getChildFragmentManager();
    }

    @Override
    ArrayList<Fragment> getFragments(String key, HashMap datas) {
        ArrayList fragments = new ArrayList<>();
        for (Object entry : datas.values()) {
            GridFragment gridFragment = new GridFragment();
            Bundle extras = new Bundle();

            extras.putStringArrayList(key, (ArrayList<String>) entry);

            gridFragment.setArguments(extras);
            fragments.add(gridFragment);
        }
        return fragments;
    }
}
