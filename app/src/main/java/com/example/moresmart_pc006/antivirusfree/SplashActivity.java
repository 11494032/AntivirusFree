package com.example.moresmart_pc006.antivirusfree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class SplashActivity extends AppCompatActivity {

    private TextView textView = null;
    private int mLocalVersionCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        textView = (TextView) findViewById( R.id.tv_splash_version );

        textView.setText("版本号："+ PackageUtils.getVersionName(this));

        mLocalVersionCode = PackageUtils.getVersionCode( this );

     //   checkVersion();
    }

    /**
     * 检测版本号
     */
    private void checkVersion()
    {
        String url = "http://192.168.1.8:8080/info.json";

        HttpUtils httpUtils = new HttpUtils( 3000 );
        httpUtils.send( HttpRequest.HttpMethod.GET, url, new RequestCallBack< String >(){

        @Override
        public void onFailure(HttpException e, String s) {

        }

        @Override
        public void onSuccess(ResponseInfo<String> responseInfo) {

        }
        });

    }

}
