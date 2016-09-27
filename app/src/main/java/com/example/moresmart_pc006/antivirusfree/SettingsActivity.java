package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SyncAdapterType;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MoreSmart-PC006 on 2016/9/26.
 */
public class SettingsActivity extends Activity {

    private SettingsItemView  sivUpdate;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getSharedPreferences("config",MODE_PRIVATE);
        setContentView( R.layout.activity_settings);
        sivUpdate = (SettingsItemView) findViewById( R.id.siv_update);

        boolean is_update = sp.getBoolean("is_update",true );
 //       sivUpdate.set_title("自动跟新设置");

        if( is_update )
        {
         //   sivUpdate.setTv_desc("自动跟新已经开启");
            sivUpdate.set_check( true );
        }
        else
        {
         //   sivUpdate.setTv_desc( "自动跟新已经关闭" );
            sivUpdate.set_check( false );
        }
        sivUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sivUpdate.get_check_statue()) {
                 //   sivUpdate.setTv_desc("自动跟新已经关闭");
                    sivUpdate.set_check(false);
                    sp.edit().putString("is_update", "false").commit();

                } else {
               //     sivUpdate.setTv_desc("自动跟新已经开启");
                    sivUpdate.set_check(true);
                    sp.edit().putString("is_update", "true").commit();
                }
            }
        });

    }





}
