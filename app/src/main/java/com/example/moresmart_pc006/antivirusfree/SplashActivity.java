package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class SplashActivity extends Activity {

    private TextView textView = null;

    private int localVersion = 0;

    private String downloadURL = null;
    private String desc = null;

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();

    }

    /**
     * 初始化窗口数据
     */
    private void initView()
    {

        textView = (TextView) findViewById( R.id.tv_splash_version );
        System.out.println(R.string.current_version);
        System.out.println(PackageUtils.getVersionName(this));
        textView.setText( R.string.current_version + PackageUtils.getVersionName(this));
        localVersion = PackageUtils.getVersionCode(this);

        sp = getSharedPreferences("config", MODE_PRIVATE );
        boolean is_update = sp.getBoolean("is_update",true);

        if( is_update ) {
            checkVersion();
        }
        else
        {
            loadMainUI();
        }

    }

    /**
     * 查询版本
     */
    private void checkVersion()
    {
        final String PATH = "http://192.168.1.17:8080/info.json";
        HttpUtils httpUtils = new HttpUtils( 3000 );
        httpUtils.send(HttpRequest.HttpMethod.GET,PATH,new RequestCallBack<String>(){
            @Override
            public void onFailure(HttpException e, String s) {
            //载入主界面
                loadMainUI();
            }

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                System.out.println(responseInfo.result);
                processData( responseInfo.result );
            }
        });

    }

    /**
     * 处理网络传输的json格式
     * @param result json 数据
     */
    private void processData( String result )
    {
        try {
            JSONObject obj = new JSONObject( result );
           downloadURL =  obj.getString( "downloadurl" );
           int netVersion =  obj.getInt( "version" );
           desc =  obj.getString( "desc" );

            if( netVersion == localVersion )
            {
                System.out.println("lastest version");
                loadMainUI();
            }
            else
            {
                showDialog();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 展示升级对话框
     */
    private void showDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(R.string.upgrade_note);

        builder.setMessage( desc );

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                loadMainUI();
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                loadMainUI();
                dialogInterface.dismiss();

            }
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                downloadApk( downloadURL );
                dialogInterface.dismiss();
            }
        });
    builder.show();
    }


    /**
     *下载apk
     * @param path apk网络路径
     */

    private void downloadApk( String path )
    {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.download(path, "/mnt/sdcard/tmp.apk", new RequestCallBack<File>() {
            @Override
            public void onSuccess(ResponseInfo<File> responseInfo) {
                //下载成功，安装apk包
                installApk("/mnt/sdcard/tmp.apk");
            }

            @Override
            public void onFailure(HttpException e, String s) {
            //下载失败
            System.out.println("download failed");
            }
        });
    }

    /**
     * 安装apk包
     * @param apkPath
     */
    private void installApk( String apkPath )
    {
        Intent intent = new Intent( Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        intent.setDataAndType(Uri.fromFile( new File(apkPath)),"application/vnd.android.package-archive");
        startActivityForResult( intent,0);
    }


    /**
     * 主界面
     */
    protected void loadMainUI()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }




}
