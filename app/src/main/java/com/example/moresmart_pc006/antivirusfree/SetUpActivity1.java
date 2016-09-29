package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by MoreSmart-PC006 on 2016/9/29.
 */
public class SetUpActivity1 extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_setup1);
    }

    public  void next(View view)
    {
        Intent intent = new Intent(this,SetUpActivity2.class);
       startActivity(intent);
    }


}
