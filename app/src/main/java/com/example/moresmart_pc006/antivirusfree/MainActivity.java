package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

    private AlertDialog alertDialog;
    private SharedPreferences sp;


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

        sim_adapter = new SimpleAdapter( this,data_list,R.layout.home_list_item,from,to);
        gvHome.setAdapter( sim_adapter );

        gvHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                System.out.println(i);
                switch( i )
                {
                    case 0:
                        showPasswordDialog();
                        break;
                    case 8:
                        //设置中心
                       // Toast.makeText(getApplicationContext(),"sss",Toast.LENGTH_LONG).show();
                        startActivity( new Intent(MainActivity.this,SettingsActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });


        sp = getSharedPreferences("password",MODE_PRIVATE);
    }

    protected void showPasswordDialog()
    {
        String password = sp.getString("password",null);
        System.out.println("password:"+password);
        if( password != null) {
            showInputPasswordDialog( password);
        }
        else {
            showPasswordSetDialog();
        }
    }

    private void  showInputPasswordDialog(final String password )
    {
        final AlertDialog.Builder builder =   new AlertDialog.Builder( this);
        alertDialog = builder.create();
        View view = View.inflate(this,R.layout.dailog_input_password,null);

        alertDialog.setView( view,0,0,0,0 );
        alertDialog.show();

        Button button_ok = (Button) view.findViewById( R.id.button_ok );
        Button button_cancel = ( Button)view.findViewById( R.id.button_cancel );

        final EditText et_password = (EditText) view.findViewById( R.id.et_password );
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input_password = et_password.getText().toString();

                if( password.equals(input_password) )
                {
                    Toast.makeText(getApplicationContext(),"密码正确",Toast.LENGTH_LONG).show();
                    alertDialog.dismiss();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"密码不对",Toast.LENGTH_LONG).show();
                }

            }

        });

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

    }


    private void  showPasswordSetDialog()
    {
        final AlertDialog.Builder builder =   new AlertDialog.Builder( this);
        alertDialog = builder.create();

        View view = View.inflate(this,R.layout.dailog_set_password,null);

        alertDialog.setView( view,0,0,0,0 );
        alertDialog.show();

        Button button_ok = (Button) view.findViewById( R.id.button_ok );
        Button button_cancel = ( Button)view.findViewById( R.id.button_cancel );
        final EditText et_password = (EditText) view.findViewById( R.id.et_password );
        final EditText et_password_con = (EditText) view.findViewById( R.id.et_password_con );

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = et_password.getText().toString();
                String password_con = et_password_con.getText().toString();


                if( !TextUtils.isEmpty(password) && !password_con.isEmpty())
                {
                    if( password.equals(password_con)) {
                        Toast.makeText(getApplicationContext(), "密码已经设置", Toast.LENGTH_SHORT).show();
                        sp.edit().putString("password",password).commit();
                        alertDialog.dismiss();
                    }
                    else
                        Toast.makeText(getApplicationContext(),"确认密码与密码不对应",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"密码不能为空",Toast.LENGTH_LONG).show();
                }

            }

        });

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });


    }

}
