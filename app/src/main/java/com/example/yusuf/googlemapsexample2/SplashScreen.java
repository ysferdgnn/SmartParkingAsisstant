package com.example.yusuf.googlemapsexample2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import static com.example.yusuf.googlemapsexample2.R.drawable.splash;

/**
 * Created by Yusuf on 14.04.2018.
 */

public class SplashScreen extends Activity {

        private int SPLASH_DURATION_MILIS=3200;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splashscreen_layout);




        final Handler handler = new Handler();
        final Runnable r = new Runnable()
        {
            public void run()
            {
                Intent intent=new Intent(SplashScreen.this,MapsActivity.class);
                startActivity(intent);
            }
        };
        handler.postDelayed(r, SPLASH_DURATION_MILIS);



    }

    @Override
    protected  void onPause() {

        super.onPause();
        finish();
    }

}
