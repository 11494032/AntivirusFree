package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by MoreSmart-PC006 on 2016/9/30.
 */
public class SetUpActivity5  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_setup5 );
    }

    public void next(View view )
    {
       // Intent intent = new Intent(this,SetUpActivity5.class);
      //  startActivity(intent);
    }
    public void pre( View view )
    {
        Intent intent = new Intent(this,SetUpActivity4.class);
        startActivity(intent);
    }
}
