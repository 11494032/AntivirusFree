package com.example.moresmart_pc006.antivirusfree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by MoreSmart-PC006 on 2016/9/29.
 */
public class SetUpActivity2 extends Activity {

    private Button button;

    private TelephonyManager telephonyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView( R.layout.activity_setup2 );

        button = (Button)findViewById( R.id.bind_unbind_sim );

        telephonyManager = (TelephonyManager)getSystemService( TELEPHONY_SERVICE );


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String num =  SharedPreferencesUtils.getString( SetUpActivity2.this,Constants.SJFD_SIM, "" );
                if(TextUtils.isEmpty( num ))
                {
                    String simSerialNumber = telephonyManager.getSimSerialNumber();
                    System.out.println(" simSerialNumber :"+simSerialNumber);
                    SharedPreferencesUtils.saveString(SetUpActivity2.this, Constants.SJFD_SIM, simSerialNumber);
                    Toast.makeText(getApplicationContext(),"已经绑定sim卡",Toast.LENGTH_LONG).show();
                }
                else
                {
                    SharedPreferencesUtils.saveString(SetUpActivity2.this, Constants.SJFD_SIM, "");
                    Toast.makeText(getApplicationContext(),"已经解除sim卡绑定",Toast.LENGTH_LONG).show();

                }

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
