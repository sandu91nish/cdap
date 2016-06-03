package com.teachme_module;

//Test Push

import android.app.Activity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Keypad extends Activity  implements View.OnClickListener{
    TextToSpeech tts;
boolean LetterA=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keypad);

        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    int result = tts.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    }
                } else {
                    Log.e("TTS", "Initilization Failed!");
                }


            }
        });


    }

    private void speakWords(String speech) {

        // speak straight away
        if (tts != null) {
            tts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


    public boolean check()
    {
        Boolean confirmA = getIntent().getExtras().getBoolean("nowinA");
        if(confirmA)
        {
            speakWords("Correct Entry of letter A");
            Intent i=new Intent(Keypad.this,Learning_Keyboard.class);
            i.putExtra("confirmB",true);
            startActivity(i);
        }
        return true;

    }

    @Override
    public void onClick(View view) {

    }

    public boolean LetterA(List<Integer> number)
    {

        int[] intArray = new int[number.size()];

        for (int i = 0; i < number.size(); i++) {
            intArray[i] = number.get(i);
        }

        int[] num1 = new int[] { R.id.button1 };

        if(Arrays.equals(intArray,num1))
        {
            speakWords("Correct Entry of Letter A, For Letter B, touch top Left and mid left of the screen");
         //   status=true;

        }

        else
        {
            speakWords("Incorrect entry of Letter A. Re enter Letter A by touching Top Left of the screen");
          //  mClickedButtonIds.clear();

        }
        return true;
    }
}
