package com.example.moresmart_pc006.antivirusfree;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by MoreSmart-PC006 on 2016/9/26.
 */
public class SettingsItemView extends RelativeLayout {


    public SettingsItemView(Context context) {
        super(context);
        initView();
    }

    public SettingsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SettingsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void  initView()
    {

        View view = View.inflate(getContext(),R.layout.view_settings_item,null);
    }
}
