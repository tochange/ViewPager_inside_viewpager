package com.fui.viewpager.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fui.viewpager.fragment.type.TypeFragment;
import com.joey.viewpager.R;

import java.util.ArrayList;


public class GridFragment extends Fragment {

    private ArrayList<String> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid, container, false);
        datas = getArguments().getStringArrayList(TypeFragment.KEY);
        TextView textView = (TextView) view.findViewById(R.id.text);

        textView.setText(datas.toString());
        return view;
    }

}
