package com.teachme_module;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Locale;

public class MainMenuGame extends AppCompatActivity  {
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    Button b1,b2,b3,b4;
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_game);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button7);
        b3=(Button)findViewById(R.id.button8);
        b4=(Button)findViewById(R.id.button9);


       RelativeLayout parentLayout=(RelativeLayout) findViewById(R.id.layout);

        assert parentLayout != null;
        parentLayout.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(MainMenuGame.this,Learning_Keyboard.class);
                startActivity(intent);
                return false;
            }
        });

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    int result = tts.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization Failed!");
                }


            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(MainMenuGame.this,Tutor_Layout.class);
//                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainMenuGame.this,InsertandRetriveData.class);
                startActivity(intent);
            }
        });

        b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                speakWords(b1.getText().toString());
                return false;
            }
        });

        b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                speakWords(b2.getText().toString());
                return false;
            }
        });

        b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                speakWords(b3.getText().toString());
                return false;
            }
        });

        b4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                speakWords(b4.getText().toString());
                return false;
            }
        });
    }



    private void speakWords(String speech) {

        // speak straight away
        if (tts != null) {
            tts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

}
