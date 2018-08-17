package com.fui.viewpager.fragment.type;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.HashMap;

public class MainType extends TypeFragment {


    @Override
    FragmentManager getFragmentManager(FragmentActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Override
    ArrayList<Fragment> getFragments(String key, HashMap datas) {
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
}
