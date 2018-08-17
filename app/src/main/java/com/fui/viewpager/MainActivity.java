package com.fui.viewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.fui.viewpager.fragment.type.MainType;
import com.fui.viewpager.fragment.type.TypeFragment;
import com.joey.viewpager.R;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    static HashMap<String, HashMap<String, ArrayList<String>>> datas = new HashMap();

    static {
        HashMap<String, ArrayList<String>> data = new HashMap();
        HashMap<String, ArrayList<String>> data2 = new HashMap();

        ArrayList<String> list2 = new ArrayList();
        list2.add("圆的");
        list2.add("大西瓜");
        data.put("西瓜", list2);

        ArrayList<String> list3 = new ArrayList();
        list3.add("绿的");
        list3.add("红富士");
        data.put("苹果", list3);


        ArrayList<String> list4 = new ArrayList();
        list4.add("黄牛");
        list4.add("牦牛");
        data2.put("牛肉", list4);

        ArrayList<String> list5 = new ArrayList();
        list5.add("肥猪");
        data2.put("猪肉", list5);

        ArrayList<String> list6 = new ArrayList();
        list6.add("大人肉");
        data2.put("人肉", list6);

        datas.put("水果", data);
        datas.put("肉", data2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);  //隐藏掉系统原先的导航栏
        setContentView(R.layout.main_root);

        MainType fragment = new MainType();

        Bundle extras = new Bundle();
        extras.putSerializable(TypeFragment.KEY, datas);
        fragment.setArguments(extras);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, fragment).commitAllowingStateLoss();
    }
}
