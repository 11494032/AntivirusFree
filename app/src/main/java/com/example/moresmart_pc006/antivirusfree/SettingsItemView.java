package com.example.moresmart_pc006.antivirusfree;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by MoreSmart-PC006 on 2016/9/26.
 */
public class SettingsItemView extends RelativeLayout {

     private static final String  NAMESPACE = "http://schemas.android.com/apk/res/com.example.moresmart_pc006.antivirusfree";
    private TextView tv_title;
    private TextView tv_desc;
    private CheckBox cb_status;

    private  String title;
    private  String desc_on;
    private  String desc_off;

    public SettingsItemView(Context context) {
        super(context);
        initView();
    }

    public SettingsItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
         title = attrs.getAttributeValue(NAMESPACE,"stitle");
         desc_on = attrs.getAttributeValue(NAMESPACE,"desc_on");
         desc_off = attrs.getAttributeValue(NAMESPACE,"desc_off");

        initView();
    }

    public SettingsItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void  initView()
    {

        View view = View.inflate(getContext(),R.layout.view_settings_item,this);
        tv_title = (TextView) findViewById( R.id.tv_title);
        tv_desc = (TextView) findViewById( R.id.tv_desc );
        cb_status = (CheckBox)findViewById( R.id.cb_status );

        set_title( title );

    }

    public void set_title( String title)
    {
        tv_title.setText( title );
    }

    public void setTv_desc( String desc )
    {
        tv_desc.setText( desc );
    }

    public boolean get_check_statue()
    {
        return cb_status.isChecked();
    }

    public void set_check( boolean check)
    {
        cb_status.setChecked( check );
        if( check )
            setTv_desc(desc_on);
        else
            setTv_desc(desc_off);
    }
}
