package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by MoreSmart-PC006 on 2016/9/29.
 */
public class SetUpActivity2 extends Activity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_setup2 );

        button = (Button)findViewById( R.id.bind_unbind_sim );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    public void next(View view )
    {
        Intent intent = new Intent(this,SetUpActivity3.class);
        startActivity(intent);
    }
    public void pre( View view )
    {
        Intent intent = new Intent(this,SetUpActivity1.class);
        startActivity(intent);
    }


}
