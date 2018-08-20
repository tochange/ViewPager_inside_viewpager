package com.fui.viewpager.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.joey.viewpager.R;

import java.util.List;

public class MainTypeAdapter extends TypeAdapter {
    public MainTypeAdapter(Activity activity, FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(activity, fm, fragments, titles);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable image = activity.getResources().getDrawable(R.mipmap.ic_launcher);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());

        SpannableString sb = new SpannableString(" \n" + mTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
