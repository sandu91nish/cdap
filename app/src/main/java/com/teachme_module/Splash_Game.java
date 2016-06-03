package com.teachme_module;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__game);

        Intent i=new Intent(Splash_Game.this,MainMenuGame.class);
        startActivity(i);
    }
}
