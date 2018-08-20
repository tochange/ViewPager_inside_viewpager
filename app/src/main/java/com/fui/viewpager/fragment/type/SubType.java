package com.fui.viewpager.fragment.type;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.fui.viewpager.adapter.SubTypeAdapter;
import com.fui.viewpager.adapter.TypeAdapter;
import com.fui.viewpager.fragment.GridFragment;
import com.joey.viewpager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SubType extends TypeFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.common_fragment_sub;
    }

    @Override
    protected FragmentManager getFragmentManager(FragmentActivity activity) {
        return getChildFragmentManager();
    }

    @Override
    protected ArrayList<Fragment> getFragments(String key, HashMap datas) {
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

    @Override
    protected TypeAdapter getAdapter(Activity activity, List<Fragment> fragments, String[] titles) {
        return new SubTypeAdapter(getActivity(), getFragmentManager(getActivity()),
                fragments, titles);
    }

}
