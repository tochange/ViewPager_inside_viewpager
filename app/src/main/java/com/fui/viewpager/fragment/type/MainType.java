package com.fui.viewpager.fragment.type;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.fui.viewpager.adapter.MainTypeAdapter;
import com.fui.viewpager.adapter.TypeAdapter;
import com.joey.viewpager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainType extends TypeFragment {


    @Override
    protected int getLayoutResId() {
        return R.layout.common_fragment_main;
    }

    @Override
    protected FragmentManager getFragmentManager(FragmentActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Override
    protected ArrayList<Fragment> getFragments(String key, HashMap datas) {
        ArrayList fragments = new ArrayList<>();
        for (Object entry : datas.values()) {
            SubType subType = new SubType();
            Bundle extras = new Bundle();

            extras.putSerializable(key, (HashMap<String, ArrayList<String>>) entry);
            subType.setArguments(extras);
            fragments.add(subType);
        }
        return fragments;
    }

    @Override
    protected TypeAdapter getAdapter(Activity activity, List<Fragment> fragments, String[] titles) {
        return new MainTypeAdapter(getActivity(), getFragmentManager(getActivity()),
                fragments, titles);
    }
}
