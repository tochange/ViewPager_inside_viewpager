package com.fui.viewpager.fragment.type;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fui.viewpager.adapter.TypeAdapter;
import com.joey.viewpager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public abstract class TypeFragment extends Fragment {
    public static final String KEY = "key";

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private HashMap<String, HashMap<String, ArrayList<String>>> mData;

    protected abstract int getLayoutResId();

    protected abstract FragmentManager getFragmentManager(FragmentActivity activity);

    protected abstract ArrayList<Fragment> getFragments(String key, HashMap datas);

    protected abstract TypeAdapter getAdapter(Activity activity, List<Fragment> fragments, String[] titles);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_main);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_menu_pager);

        mData = (HashMap) getArguments().getSerializable(KEY);
        initData();
        return view;
    }

    private void initData() {
        List<Fragment> fragments = getFragments(KEY, mData);
        String[] titles = mData.keySet().toArray(new String[mData.keySet().size()]);
        TypeAdapter adapter = getAdapter(getActivity(), fragments, titles);
        mViewPager.setOffscreenPageLimit(mData.keySet().size());
        mViewPager.setAdapter(adapter);
        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
