package com.teachme_module;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Instruction_Module extends Activity implements View.OnClickListener, GestureDetector.OnDoubleTapListener, View.OnTouchListener,View.OnLongClickListener{
    private TextToSpeech tts;
    boolean isStarted = false;
    private List<Integer> mClickedButtonIds = new ArrayList<Integer>();
    Button b1, b2, b3, b4, b5, b6;
    boolean nowinA, nowinB, nowinC, nowinD, nowinE, nowinF = false;
    boolean confirmA=false;
    ImageButton img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction__module);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);


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


        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    speakWords("Hi guys...");
                    sleep(2000);
                    speakWords("This is Tutor session of alphabet");
                    sleep(3000);
                    speakWords("Screen consists with six divided keypads and give answers using by touching the keypad");
                    nowinA = true;


                    sleep(3000);
                    speakWords("A for Apple. Blank, P, P, L, E. Fill the blank with letter A.");

                    sleep(3000);
                    speakWords("Type the letter A, Give a long press on the screen");


                    img.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View view) {
                            Intent i=new Intent(Instruction_Module.this,Keypad.class);
                            startActivity(i);
                            speakWords("Type the valid letter for previous question");
                            return false;
                        }
                    });



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        logoTimer.start();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      //  client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void speakWords(String speech) {

        // speak straight away
        if (tts != null) {
            tts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
        }
    }


    @Override
    public void onClick(View view) {

    }

    public boolean onLongClick(View v)
    {

        return true;
    }
    public boolean getCall(List<Integer> number) {

        int[] intArray = new int[number.size()];
        for (int i = 0; i < number.size(); i++) {
            intArray[i] = number.get(i);
        }

        int[] p1 = new int[]{R.id.button1};
        int[] p2 = new int[]{R.id.button2};
        int[] p3 = new int[]{R.id.button3};
        int[] p4 = new int[]{R.id.button4};
        int[] p5 = new int[]{R.id.button5};
        int[] p6 = new int[]{R.id.button6};

        Arrays.sort(intArray);

        if (nowinA) {
            if (Arrays.equals(intArray, p1)) {

                speakWords("You are touching Top Left side of the screen");
                nowinA = false;
                nowinB = true;
                return true;

            } else if ((Arrays.equals(intArray, p2)) || (Arrays.equals(intArray, p3)) || (Arrays.equals(intArray, p4)) || (Arrays.equals(intArray, p5)) || (Arrays.equals(intArray, p6))) {
                speakWords("Invalid Touch of Top Left. ");
            }

        } else {
            if (nowinB) {
                if (Arrays.equals(intArray, p2)) {

                    speakWords("Top Right");
                    nowinB = false;
                    nowinC = true;

                }
            } else {
                if (nowinC) {
                    if (Arrays.equals(intArray, p3)) {

                       speakWords("Mid Left");
                        nowinC = false;
                        nowinD = true;

                    }

                } else {
                    if (nowinD) {

                        if (Arrays.equals(intArray, p4)) {

                            speakWords("Mid Right");
                            nowinD = false;
                            nowinE = true;

                        }
                    } else {
                        if (nowinE) {
                            if (Arrays.equals(intArray, p5)) {

                               speakWords("Bottom Left");
                                nowinE = false;
                                nowinF = true;

                            }

                        } else {

                            if (!Arrays.equals(intArray, p1) && !Arrays.equals(intArray, p2) && !Arrays.equals(intArray, p3) && !Arrays.equals(intArray, p4) && !Arrays.equals(intArray, p5) && !Arrays.equals(intArray, p6)) {
                                speakWords("Invalid Touch");
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        View view = null;
        if (!isStarted) {
            isStarted = true;
            mClickedButtonIds.add(view.getId());
            new Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            isStarted = false;

                            getCall(mClickedButtonIds);
                            mClickedButtonIds.clear();
                        }
                    },
                    3000);

        } else {
            mClickedButtonIds.add(view.getId());
        }
        return true;

    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
//        if (!isStarted) {
//            isStarted = true;
//            mClickedButtonIds.add(view.getId());
//            new android.os.Handler().postDelayed(
//                    new Runnable() {
//                        public void run() {
//                            isStarted = false;
//
//                            getCall(mClickedButtonIds);
//                            mClickedButtonIds.clear();
//                        }
//                    },
//                    3000);
//
//        } else {
//            mClickedButtonIds.add(view.getId());
//        }
        return true;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Instruction_Module Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.teachme_module/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Instruction_Module Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://com.teachme_module/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
}
