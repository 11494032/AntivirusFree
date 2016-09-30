package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by MoreSmart-PC006 on 2016/9/29.
 */
public class SetUpActivity3 extends Activity{

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_setup3 );

        button = (Button) findViewById( R.id.bt_contact);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void next(View view )
    {
        Intent intent = new Intent(this,SetUpActivity4.class);
        startActivity(intent);
    }
    public void pre( View view )
    {
        Intent intent = new Intent(this,SetUpActivity2.class);
        startActivity(intent);
    }
}
