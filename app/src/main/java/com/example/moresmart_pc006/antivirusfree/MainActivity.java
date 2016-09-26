package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by MoreSmart-PC006 on 2016/9/14.
 */
public class MainActivity extends Activity {

    private GridView gvHome;

    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;

    //初始化图片
    private  int[] ICONID = new int[]{
            R.drawable.home_safe,            R.drawable.home_callmsgsafe,
            R.drawable.home_apps,            R.drawable.home_taskmanager,
            R.drawable.home_netmanager,       R.drawable.home_trojan,
            R.drawable.home_sysoptimize,    R.drawable.home_tools,
            R.drawable.home_settings};

    private String[] TITLES = new String[]{
            "手机防盗","骚扰拦截",
            "软件管理","进程管理",
            "流量统计","手机杀毒",
            "缓存清理","常用工具",
            "常用设置"
    };

    public void initData()
    {
        data_list = new ArrayList<Map<String, Object>>();


         for( int i = 0; i < TITLES.length; i++  ) {
             HashMap<String, Object> hashMap = new HashMap<String, Object>();
             hashMap.put("image",ICONID[i] );
             hashMap.put("title",TITLES[i]);
             data_list.add( hashMap );
         }


    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initData();

        gvHome = (GridView) findViewById( R.id.gv_home );
        String[] from = new String[]{"image", "title"};
        int[] to = new int[]{ R.id.iv_item,R.id.tv_item};
//Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to
        sim_adapter = new SimpleAdapter( this,data_list,R.layout.home_list_item,from,to);
        gvHome.setAdapter( sim_adapter );
    }



}
