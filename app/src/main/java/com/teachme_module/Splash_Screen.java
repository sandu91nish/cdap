package com.teachme_module;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(5*1000);

                    // After 5 seconds redirect to another intent
                    Intent intent = new Intent(Splash_Screen.this, Learning_Keyboard.class);
                    startActivity(intent);


                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }
}
