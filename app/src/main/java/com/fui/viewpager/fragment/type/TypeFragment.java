package com.fui.viewpager.fragment.type;

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

import com.fui.viewpager.TypeAdapter;
import com.joey.viewpager.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public abstract class TypeFragment extends Fragment {
    private ViewPager mViewPager;
    private TypeAdapter mMyTabFragmentPagerAdapter;
    private List<Fragment> fragments;
    private TabLayout mTabLayout;

    public static final String KEY = "key";

    private HashMap<String, HashMap<String, ArrayList<String>>> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_fragment, container, false);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab_main);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_menu_pager);

        datas = (HashMap) getArguments().getSerializable(KEY);
        initdata();
        return view;
    }

    abstract FragmentManager getFragmentManager(FragmentActivity activity);

    abstract ArrayList<Fragment> getFragments(String key, HashMap datas);

    //初始化数据
    private void initdata() {
        fragments = getFragments(KEY, datas);

        String[] arrayString = datas.keySet().toArray(new String[datas.keySet().size()]);
        mMyTabFragmentPagerAdapter = new TypeAdapter(getFragmentManager(getActivity())
                , fragments, arrayString);
        mViewPager.setOffscreenPageLimit(datas.keySet().size());
        mViewPager.setAdapter(mMyTabFragmentPagerAdapter);
        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
