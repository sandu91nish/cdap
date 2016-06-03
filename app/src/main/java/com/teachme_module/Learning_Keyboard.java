package com.teachme_module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Learning_Keyboard extends Activity implements View.OnClickListener, GestureDetector.OnDoubleTapListener {

    private TextToSpeech tts;
    boolean isStarted = false;
    boolean status = false;
    private List<Integer> mClickedButtonIds = new ArrayList<Integer>();
    Button b1, b2, b3, b4, b5, b6;
    boolean confirmtap1, confirmtap2 = false;
    int[] intArrayB;

    boolean nowinA, nowinB, nowinC, nowinD, nowinE, nowinF, nowinG, nowinH, nowinI, nowinJ, nowinK, nowinL, nowinM, nowinN, nowinO, nowinP, nowinQ, nowinR, nowinS, nowinT, nowinU, nowinV, nowinW, nowinX, nowinY, nowinZ = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning__keyboard);

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


        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    speakWords("Hi guys...");
                    sleep(2000);
                    speakWords("you are in Teach Me learning module forum");
                    sleep(3000);
                    speakWords("Lets start on learning english letters using braille ");
                    sleep(3000);
                    speakWords("For Letter A, give a single tap on the top left side of the screen");
                    nowinA = true;


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        logoTimer.start();

    }

    private void speakWords(String speech) {

        // speak straight away
        if (tts != null) {
            tts.setSpeechRate(1);
            tts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);

        }
    }

    @Override
    public void onClick(final View view) {
        if (!isStarted) {
            isStarted = true;
            mClickedButtonIds.add(view.getId());
            new android.os.Handler().postDelayed(
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
    }


    public boolean getCall(List<Integer> number) {

        int[] intArray = new int[number.size()];

        for (int i = 0; i < number.size(); i++) {
            intArray[i] = number.get(i);
        }


        int[] num0 = new int[]{R.id.button2, R.id.button3, R.id.button4};
        int[] num1 = new int[]{R.id.button1};
        int[] num2 = new int[]{R.id.button1, R.id.button3};
        int[] num3 = new int[]{R.id.button1, R.id.button2};
        int[] num4 = new int[]{R.id.button1, R.id.button2, R.id.button4};
        int[] num5 = new int[]{R.id.button1, R.id.button4};
        int[] num6 = new int[]{R.id.button1, R.id.button2, R.id.button3};
        int[] num7 = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4};
        int[] num8 = new int[]{R.id.button1, R.id.button3, R.id.button4};
        int[] num9 = new int[]{R.id.button2, R.id.button3};
        int[] num10 = new int[]{R.id.button2, R.id.button3, R.id.button4};
        int[] num11 = new int[]{R.id.button1, R.id.button5};
        int[] num12 = new int[]{R.id.button1, R.id.button3, R.id.button5};
        int[] num13 = new int[]{R.id.button1, R.id.button2, R.id.button5};
        int[] num14 = new int[]{R.id.button1, R.id.button2, R.id.button4, R.id.button5};
        int[] num15 = new int[]{R.id.button1, R.id.button4, R.id.button5};
        int[] num16 = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button5};
        int[] num17 = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5};
        int[] num18 = new int[]{R.id.button1, R.id.button3, R.id.button4, R.id.button5};
        int[] num19 = new int[]{R.id.button2, R.id.button3, R.id.button5};
        int[] num20 = new int[]{R.id.button2, R.id.button3, R.id.button4, R.id.button5};
        int[] num21 = new int[]{R.id.button1, R.id.button5, R.id.button6};
        int[] num22 = new int[]{R.id.button1, R.id.button3, R.id.button5, R.id.button6};
        int[] num23 = new int[]{R.id.button2, R.id.button3, R.id.button4, R.id.button6};
        int[] num24 = new int[]{R.id.button1, R.id.button2, R.id.button5, R.id.button6};
        int[] num25 = new int[]{R.id.button1, R.id.button2, R.id.button4, R.id.button5, R.id.button6};
        int[] num26 = new int[]{R.id.button1, R.id.button4, R.id.button5, R.id.button6};


        Arrays.sort(intArray);
        Arrays.sort(num1);
        Arrays.sort(num2);
        Arrays.sort(num3);




        if (intArray == null) {
            System.out.println("Please enter the letter");
            return true;

        }
        if (Arrays.equals(intArray, num0)) {

            speakWords("This is  Number 0");

            return true;

        }
        if (nowinA) {

            if (compareArrays(intArray,num1)==1) {

                speakWords("This is Letter A. For letter B first single tap on the Top Left side and then single tap on the Mid Left side of the screen");
                nowinA = false;
                nowinB = true;
                return true;


            } else if((compareArrays(intArray,num1)==-1))
            {
                speakWords("Please enter the letter" );
            }
            else if ((compareArrays(intArray,num1)==-2))
            {
                speakWords("Order of entering taps of the letter is in incorrect. Please re enter Letter A by giving a single tap on the top left side of the screen " );

            }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                speakWords("Incorrect entry of Letter A. Re enter Letter A by giving a single tap on the top left side of the screen");
                mClickedButtonIds.clear();

            } else {
                speakWords("Incorrect entry of Letter A. Re enter Letter A by giving a single tap on the top left side of the screen");
                mClickedButtonIds.clear();
            }
        } else {
            if (nowinB) {

                if(compareArrays(intArray,num2)==1) {

                    speakWords("This is Letter B. For letter C first give single tap on Top Left side and then give single tap on the Top Right side of the screen");
                    nowinB = false;
                    nowinC = true;
                    return true;

                }
                else if((compareArrays(intArray,num1)==-1))
                {
                    speakWords("Please enter the letter" );
                }
                else if ((compareArrays(intArray,num1)==-2))
                {
                    speakWords("Order of entering taps of the letter is in incorrect. Please re enter letter B by giving single tap on the Top Left side and then single tap on the Mid Left side of the screen" );

                }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                    speakWords("Incorrect entry of Letter B. Re enter letter B by giving single tap on the Top Left side and then single tap on the Mid Left side of the screen");
                    mClickedButtonIds.clear();

                } else {
                    speakWords("Incorrect entry of Letter B. Re enter letter B by giving single tap on the Top Left side and then single tap on the Mid Left side of the screen");
                    mClickedButtonIds.clear();
                }
            } else {
                if (nowinC) {
                    if (compareArrays(intArray,num3)==1) {

                        speakWords("This is Letter C. Now enter letter D by giving first single tap on Top Left side,then single tap on the Top Right side and finally single tap on the Mid Right side of the screen");
                        nowinC = false;
                        nowinD = true;
                        return true;

                    }
                    else if((compareArrays(intArray,num1)==-1))
                    {
                        speakWords("Please enter the letter" );
                    }
                    else if ((compareArrays(intArray,num1)==-2))
                    {
                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter C by giving first single tap on Top Left side and then give single tap on the Top Right side of the screen" );

                    }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                        speakWords("Incorrect entry of Letter C. Re enter letter C by giving first single tap on Top Left side and then give single tap on the Top Right side of the screen");
                        mClickedButtonIds.clear();

                    } else {
                        speakWords("Incorrect entry of Letter C. Re enter letter C by giving first single tap on Top Left side and then give single tap on the Top Right side of the screen");
                        mClickedButtonIds.clear();
                    }
                } else {
                    if (nowinD) {
                        if (compareArrays(intArray,num4)==1) {

                            speakWords("This is Letter D. Now enter letter E by giving first give single tap on the Top Left side, then single tap on Mid Right side of the screen");
                            nowinD = false;
                            nowinE = true;
                            return true;

                        }
                        else if((compareArrays(intArray,num1)==-1))
                        {
                            speakWords("Please enter the letter" );
                        }
                        else if ((compareArrays(intArray,num1)==-2))
                        {
                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter D by giving first single tap on Top Left side,then single tap on the Top Right side and finally single tap on the Mid Right side of the screen" );

                        }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                            speakWords("Incorrect entry of Letter D. Re enter letter D by giving first single tap on Top Left side,then single tap on the Top Right side and finally single tap on the Mid Right side of the screen");
                            mClickedButtonIds.clear();

                        } else {
                            speakWords("Incorrect entry of Letter D. Re enter letter D by giving first single tap on Top Left side,then single tap on the Top Right side and finally single tap on the Mid Right side of the screen");
                            mClickedButtonIds.clear();
                        }
                    } else {

                        if (nowinE) {
                            if (compareArrays(intArray,num5)==1) {

                                speakWords("This is Letter E. Now enter letter F by giving first give single tap on the Top Left side, then single tap of Top Right side and finally give single tap on Mid Right of the screen");
                                nowinE = false;
                                nowinF = true;
                                return true;

                            }
                            else if((compareArrays(intArray,num1)==-1))
                            {
                                speakWords("Please enter the letter" );
                            }
                            else if ((compareArrays(intArray,num1)==-2))
                            {
                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter E by giving first give single tap on the Top Left side, then single tap on Mid Right side of the screen" );

                            }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                speakWords("Incorrect entry of Letter E. Re enter letter E by giving first give single tap on the Top Left side, then single tap on Mid Right side of the screen");
                                mClickedButtonIds.clear();

                            } else {
                                speakWords("Incorrect entry of Letter E. Re enter letter E by giving first give single tap on the Top Left side, then single tap on Mid Right side of the screen");
                                mClickedButtonIds.clear();
                            }

                        } else {

                            if (nowinF) {
                                if (compareArrays(intArray,num6)==1) {

                                    speakWords("This is Letter F. Now enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                    nowinF = false;
                                    nowinG = true;
                                    return true;

                                }
                                else if((compareArrays(intArray,num1)==-1))
                                {
                                    speakWords("Please enter the letter" );
                                }
                                else if ((compareArrays(intArray,num1)==-2))
                                {
                                    speakWords("Order of entering taps of the letter is in incorrect. Please re enter letter F by giving first give single tap on the Top Left side, then single tap of Top Right side and finally give single tap on Mid Left of the screen" );

                                }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                    speakWords("Incorrect entry of Letter F. Re enter letter F by giving first give single tap on the Top Left side, then single tap of Top Right side and finally give single tap on Mid Left of the screen");
                                    mClickedButtonIds.clear();

                                } else {
                                    speakWords("Incorrect entry of Letter F. Re enter letter F by giving first give single tap on the Top Left side, then single tap of Top Right side and finally give single tap on Mid Left of the screen");
                                    mClickedButtonIds.clear();
                                }

                            } else {
                                if (nowinG) {
                                    if (compareArrays(intArray,num7)==1) {

                                        speakWords("This is Letter G. Now enter letter H by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                        nowinG = false;
                                        nowinH = true;
                                        return true;

                                    }
                                    else if((compareArrays(intArray,num1)==-1))
                                    {
                                        speakWords("Please enter the letter" );
                                    }
                                    else if ((compareArrays(intArray,num1)==-2))
                                    {
                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen" );

                                    }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                        speakWords("Incorrect entry of Letter G. Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                        mClickedButtonIds.clear();

                                    } else {
                                        speakWords("Incorrect entry of Letter G. Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                        mClickedButtonIds.clear();
                                    }

                                } else {
                                    if (nowinH) {
                                        if (compareArrays(intArray,num8)==1) {

                                            speakWords("This is Letter H. Now enter letter I by giving first give single tap on the Top Right side, then single tap of Mid Left side of the screen");
                                            nowinH = false;
                                            nowinI = true;
                                            return true;

                                        }
                                        else if((compareArrays(intArray,num1)==-1))
                                        {
                                            speakWords("Please enter the letter" );
                                        }
                                        else if ((compareArrays(intArray,num1)==-2))
                                        {
                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter H by giving first give single tap on the Top Left side, then single tap on Mid Left and finally single tap on Mid Right side of the screen" );

                                        }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                            speakWords("Incorrect entry of Letter G. Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                            mClickedButtonIds.clear();

                                        } else {
                                            speakWords("Incorrect entry of Letter G. Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                            mClickedButtonIds.clear();
                                        }

                                    } else {
                                        if (nowinI) {
                                            if (compareArrays(intArray,num9)==1) {

                                                speakWords("This is Letter I. Now enter letter J by giving first give single tap on the Top Right side, then single tap of Mid Left side, finally give single tap on Mid Right of the screen");
                                                nowinI = false;
                                                nowinJ = true;
                                                return true;

                                            }
                                            else if((compareArrays(intArray,num1)==-1))
                                            {
                                                speakWords("Please enter the letter" );
                                            }
                                            else if ((compareArrays(intArray,num1)==-2))
                                            {
                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter I by giving first give single tap on the Top Right side, then single tap of Mid Left side of the screen" );

                                            }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                speakWords("Incorrect entry of Letter I. Re enter letter I by giving first give single tap on the Top Right side, then single tap of Mid Left side of the screen");
                                                mClickedButtonIds.clear();

                                            } else {
                                                speakWords("Incorrect entry of Letter I. Re enter letter I by giving first give single tap on the Top Right side, then single tap of Mid Left side of the screen");
                                                mClickedButtonIds.clear();
                                            }

                                        } else {

                                            if (nowinJ) {
                                                if (compareArrays(intArray,num10)==1) {

                                                    speakWords("This is Letter J. Now enter letter K by giving first give single tap on the Top Left side, then single tap of Bottom Left side of the screen");
                                                    nowinJ = false;
                                                    nowinK = true;
                                                    return true;

                                                }
                                                else if((compareArrays(intArray,num1)==-1))
                                                {
                                                    speakWords("Please enter the letter" );
                                                }
                                                else if ((compareArrays(intArray,num1)==-2))
                                                {
                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter J by giving first give single tap on the Top Right side, then single tap of Mid Left side, finally give single tap on Mid Right of the screen" );

                                                }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                    speakWords("Incorrect entry of Letter J. Re enter letter J by giving first give single tap on the Top Right side, then single tap of Mid Left side, finally give single tap on Mid Right of the screen");
                                                    mClickedButtonIds.clear();

                                                } else {
                                                    speakWords("Incorrect entry of Letter J. Re enter letter J by giving first give single tap on the Top Right side, then single tap of Mid Left side, finally give single tap on Mid Right of the screen");
                                                }

                                            } else {
                                                if (nowinK) {
                                                    if (compareArrays(intArray,num1)==11) {

                                                        speakWords("This is Letter K. Now enter letter L by giving first give single tap on the Top Left side, then single tap of Mid Left side and finally single tap on the Bottom Left of the screen");
                                                        nowinK = false;
                                                        nowinL = true;
                                                        return true;

                                                    }
                                                    else if((compareArrays(intArray,num1)==-1))
                                                    {
                                                        speakWords("Please enter the letter" );
                                                    }
                                                    else if ((compareArrays(intArray,num1)==-2))
                                                    {
                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter K by giving first give single tap on the Top Left side, then single tap of Bottom Left side of the screen" );

                                                    }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                        speakWords("Incorrect entry of Letter K. Re enter letter K by giving first give single tap on the Top Left side, then single tap of Bottom Left side of the screen");
                                                        mClickedButtonIds.clear();

                                                    } else {
                                                        speakWords("Incorrect entry of Letter K. Re enter letter K by giving first give single tap on the Top Left side, then single tap of Bottom Left side of the screen");
                                                    }

                                                } else {
                                                    if (nowinL) {
                                                        if (compareArrays(intArray,num12)==1) {

                                                            speakWords("This is Letter L. Now enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side and finally single tap on the Bottom Right of the screen");
                                                            nowinL = false;
                                                            nowinM = true;
                                                            return true;

                                                        }
                                                        else if((compareArrays(intArray,num1)==-1))
                                                        {
                                                            speakWords("Please enter the letter" );
                                                        }
                                                        else if ((compareArrays(intArray,num1)==-2))
                                                        {
                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter L by giving first give single tap on the Top Left side, then single tap of Mid Left side and finally single tap on the Bottom Left of the screen" );

                                                        }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                            speakWords("Incorrect entry of Letter L. Re enter letter L by giving first give single tap on the Top Left side, then single tap of Mid Left side and finally single tap on the Bottom Left of the screen");
                                                            mClickedButtonIds.clear();

                                                        } else {
                                                            speakWords("Incorrect entry of Letter L. Re enter letter L by giving first give single tap on the Top Left side, then single tap of Mid Left side and finally single tap on the Bottom Left of the screen");
                                                        }

                                                    } else {
                                                        if (nowinM) {
                                                            if (compareArrays(intArray,num1)==13) {

                                                                speakWords("This is Letter M. Now enter letter N by giving first give single tap on the Top Left side, then single tap of Top Right side,then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                nowinM = false;
                                                                nowinN = true;
                                                                return true;

                                                            }
                                                            else if((compareArrays(intArray,num1)==-1))
                                                            {
                                                                speakWords("Please enter the letter" );
                                                            }
                                                            else if ((compareArrays(intArray,num1)==-2))
                                                            {
                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side and finally single tap on the Bottom Right of the screen" );

                                                            }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                speakWords("Incorrect entry of Letter M. Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side and finally single tap on the Bottom Right of the screen");
                                                                mClickedButtonIds.clear();

                                                            } else {
                                                                speakWords("Incorrect entry of Letter M. Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side and finally single tap on the Bottom Right of the screen");
                                                            }

                                                        } else {
                                                            if (nowinN) {
                                                                if (compareArrays(intArray,num14)==1) {

                                                                    speakWords("This is Letter N. Now enter letter O by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                    nowinN = false;
                                                                    nowinO = true;
                                                                    return true;

                                                                }
                                                                else if((compareArrays(intArray,num1)==-1))
                                                                {
                                                                    speakWords("Please enter the letter" );
                                                                }
                                                                else if ((compareArrays(intArray,num1)==-2))
                                                                {
                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter N by giving first give single tap on the Top Left side, then single tap of Top Right side,then single tap on Mid Right and finally single tap on the Bottom Left of the screen" );

                                                                }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                    speakWords("Incorrect entry of Letter M. Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side,then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                    mClickedButtonIds.clear();

                                                                } else {
                                                                    speakWords("Incorrect entry of Letter M. Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side,then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                }

                                                            } else {
                                                                if (nowinO) {
                                                                    if (compareArrays(intArray,num15)==1) {

                                                                        speakWords("This is Letter O. Now enter letter P by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                        nowinN = false;
                                                                        nowinO = true;
                                                                        return true;

                                                                    }
                                                                    else if((compareArrays(intArray,num1)==-1))
                                                                    {
                                                                        speakWords("Please enter the letter" );
                                                                    }
                                                                    else if ((compareArrays(intArray,num1)==-2))
                                                                    {
                                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter O by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen" );

                                                                    }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                        speakWords("Incorrect entry of Letter O. Re enter letter O by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                        mClickedButtonIds.clear();

                                                                    } else {
                                                                        speakWords("Incorrect entry of Letter O. Re enter letter O by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                    }

                                                                } else {
                                                                    if (nowinP) {
                                                                        if (compareArrays(intArray,num16)==1) {

                                                                            speakWords("This is Letter P. Now enter letter Q by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                            nowinP = false;
                                                                            nowinQ = true;
                                                                            return true;

                                                                        }
                                                                        else if((compareArrays(intArray,num1)==-1))
                                                                        {
                                                                            speakWords("Please enter the letter" );
                                                                        }
                                                                        else if ((compareArrays(intArray,num1)==-2))
                                                                        {
                                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter P by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left and finally single tap on the Bottom Left of the screen" );

                                                                        }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                            speakWords("Incorrect entry of Letter P. Re enter letter P by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                            mClickedButtonIds.clear();

                                                                        } else {
                                                                            speakWords("Incorrect entry of Letter P. Re enter letter P by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                        }



                                                                    } else {
                                                                        if (nowinQ) {
                                                                            if (compareArrays(intArray,num17)==1) {

                                                                                speakWords("This is Letter P. Now enter letter R by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right, then single tap on Bottom Left     of the screen");
                                                                                nowinQ = false;
                                                                                nowinR = true;
                                                                                return true;

                                                                            }
                                                                            else if((compareArrays(intArray,num1)==-1))
                                                                            {
                                                                                speakWords("Please enter the letter" );
                                                                            }
                                                                            else if ((compareArrays(intArray,num1)==-2))
                                                                            {
                                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter Q by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left, then single tap on Mid Right and finally single tap on the Bottom Left of the screen" );

                                                                            }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                speakWords("Incorrect entry of Letter Q. Re enter letter Q by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                                mClickedButtonIds.clear();

                                                                            } else {
                                                                                speakWords("Incorrect entry of Letter Q. Re enter letter Q by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                            }

                                                                        } else {
                                                                            if(nowinR)
                                                                            {
                                                                                if (compareArrays(intArray,num18)==1) {

                                                                                    speakWords("This is Letter R. Now enter letter S by giving first give single tap on the Top Right side, then single tap of Mid Left side, and finally single tap on the Bottom Left");
                                                                                    nowinR = false;
                                                                                    nowinS = true;
                                                                                    return true;

                                                                                }
                                                                                else if((compareArrays(intArray,num1)==-1))
                                                                                {
                                                                                    speakWords("Please enter the letter" );
                                                                                }
                                                                                else if ((compareArrays(intArray,num1)==-2))
                                                                                {
                                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter R by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right, then single tap on Bottom Left of the screen" );

                                                                                }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                    speakWords("Incorrect entry of Letter R. Re enter letter R by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right, then single tap on Bottom Left of the screen");
                                                                                    mClickedButtonIds.clear();

                                                                                } else {
                                                                                    speakWords("Incorrect entry of Letter R. Re enter letter R by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right, then single tap on Bottom Left  of the screen");
                                                                                }

                                                                            }
                                                                            else {
                                                                                if(nowinS)
                                                                                {
                                                                                    if (compareArrays(intArray,num19)==1) {

                                                                                        speakWords("This is Letter S. Now enter letter T by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                                        nowinS = false;
                                                                                        nowinT = true;
                                                                                        return true;

                                                                                    }
                                                                                    else if((compareArrays(intArray,num1)==-1))
                                                                                    {
                                                                                        speakWords("Please enter the letter" );
                                                                                    }
                                                                                    else if ((compareArrays(intArray,num1)==-2))
                                                                                    {
                                                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter S by giving first give single tap on the Top Right side, then single tap of Mid Left side, and finally single tap on the Bottom Left side of the screen" );

                                                                                    }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                        speakWords("Incorrect entry of Letter S. Re enter letter S by giving first give single tap on the Top Right side, then single tap of Mid Left side, and finally single tap on the Bottom Left");
                                                                                        mClickedButtonIds.clear();

                                                                                    } else {
                                                                                        speakWords("Incorrect entry of Letter S. Re enter letter S by giving first give single tap on the Top Right side, then single tap of Mid Left side, and finally single tap on the Bottom Left");
                                                                                    }

                                                                                }
                                                                                else {
                                                                                    if(nowinT)
                                                                                    {
                                                                                        if (compareArrays(intArray,num20)==1) {

                                                                                            speakWords("This is Letter T. Now enter letter U by giving first give single tap on the Top Left side, then single tap of Bottom Left side, finally single tap on the Bottom Right of the screen");
                                                                                            nowinS = false;
                                                                                            nowinT = true;
                                                                                            return true;

                                                                                        }
                                                                                        else if((compareArrays(intArray,num1)==-1))
                                                                                        {
                                                                                            speakWords("Please enter the letter" );
                                                                                        }
                                                                                        else if ((compareArrays(intArray,num1)==-2))
                                                                                        {
                                                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter T by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Left of the screen" );

                                                                                        }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                            speakWords("Incorrect entry of Letter T. Re enter letter T by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                                            mClickedButtonIds.clear();

                                                                                        } else {
                                                                                            speakWords("Incorrect entry of Letter T. Re enter letter T by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                                        }


                                                                                    }
                                                                                    else {
                                                                                        if(nowinU)
                                                                                        {
                                                                                            if (compareArrays(intArray,num21)==1) {

                                                                                                speakWords("This is Letter U. Now enter letter V by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                nowinU = false;
                                                                                                nowinV = true;
                                                                                                return true;

                                                                                            }
                                                                                            else if((compareArrays(intArray,num1)==-1))
                                                                                            {
                                                                                                speakWords("Please enter the letter" );
                                                                                            }
                                                                                            else if ((compareArrays(intArray,num1)==-2))
                                                                                            {
                                                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter U by giving first give single tap on the Top Left side, then single tap of Bottom Left side, finally single tap on the Bottom Right of the screen" );

                                                                                            }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                speakWords("Incorrect entry of Letter U. Re enter letter U by giving first give single tap on the Top Left side, then single tap of Bottom Left side, finally single tap on the Bottom Right of the screen");
                                                                                                mClickedButtonIds.clear();

                                                                                            } else {
                                                                                                speakWords("Incorrect entry of Letter U. Re enter letter U by giving first give single tap on the Top Left side, then single tap of Bottom Left side, finally single tap on the Bottom Right of the screen");
                                                                                            }

                                                                                        }
                                                                                        else {
                                                                                            if(nowinV)
                                                                                            {
                                                                                                if (compareArrays(intArray,num22)==1) {

                                                                                                    speakWords("This is Letter V. Now enter letter W by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                    nowinV = false;
                                                                                                    nowinW = true;
                                                                                                    return true;

                                                                                                }
                                                                                                else if((compareArrays(intArray,num1)==-1))
                                                                                                {
                                                                                                    speakWords("Please enter the letter" );
                                                                                                }
                                                                                                else if ((compareArrays(intArray,num1)==-2))
                                                                                                {
                                                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter V by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen" );

                                                                                                }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                    speakWords("Incorrect entry of Letter V. Re enter letter V by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                    mClickedButtonIds.clear();

                                                                                                } else {
                                                                                                    speakWords("Incorrect entry of Letter V. Re enter letter V by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                }

                                                                                            }
                                                                                            else {
                                                                                                if(nowinW)
                                                                                                {
                                                                                                    if (compareArrays(intArray,num23)==1) {

                                                                                                        speakWords("This is Letter W. Now enter letter X by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                        nowinW = false;
                                                                                                        nowinX = true;
                                                                                                        return true;

                                                                                                    }
                                                                                                    else if((compareArrays(intArray,num1)==-1))
                                                                                                    {
                                                                                                        speakWords("Please enter the letter" );
                                                                                                    }
                                                                                                    else if ((compareArrays(intArray,num1)==-2))
                                                                                                    {
                                                                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter W by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen" );

                                                                                                    }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                        speakWords("Incorrect entry of Letter W. Re enter letter W by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                        mClickedButtonIds.clear();

                                                                                                    } else {
                                                                                                        speakWords("Incorrect entry of Letter W. Re enter letter W by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                    }

                                                                                                }
                                                                                                else {
                                                                                                    if(nowinX)
                                                                                                    {
                                                                                                        if (compareArrays(intArray,num24)==1) {

                                                                                                            speakWords("This is Letter X. Now enter letter Y by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Right ,then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                            nowinX = false;
                                                                                                            nowinY = true;
                                                                                                            return true;

                                                                                                        }
                                                                                                        else if((compareArrays(intArray,num1)==-1))
                                                                                                        {
                                                                                                            speakWords("Please enter the letter" );
                                                                                                        }
                                                                                                        else if ((compareArrays(intArray,num1)==-2))
                                                                                                        {
                                                                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter X by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen" );

                                                                                                        }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                            speakWords("Incorrect entry of Letter X. Re enter letter X by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen ");
                                                                                                            mClickedButtonIds.clear();

                                                                                                        } else {
                                                                                                            speakWords("Incorrect entry of Letter X. Re enter letter X by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                        }

                                                                                                    }
                                                                                                    else {
                                                                                                        if(nowinY)
                                                                                                        {
                                                                                                            if (compareArrays(intArray,num25)==1) {

                                                                                                                speakWords("This is Letter Y. Now enter letter Z by giving first give single tap on the Top Left side, then single tap of Mid Right side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                                nowinY = false;
                                                                                                                nowinZ = true;
                                                                                                                return true;

                                                                                                            }
                                                                                                            else if((compareArrays(intArray,num1)==-1))
                                                                                                            {
                                                                                                                speakWords("Please enter the letter" );
                                                                                                            }
                                                                                                            else if ((compareArrays(intArray,num1)==-2))
                                                                                                            {
                                                                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter Y by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Right ,then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen" );

                                                                                                            }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num26)) {
                                                                                                                speakWords("Incorrect entry of Letter Y. Re enter letter Y by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Right ,then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen ");
                                                                                                                mClickedButtonIds.clear();

                                                                                                            } else {
                                                                                                                speakWords("Incorrect entry of Letter Y. Re enter letter Y by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Right ,then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                            }

                                                                                                        }
                                                                                                        else {
                                                                                                            if(nowinZ)
                                                                                                            {
                                                                                                                if (compareArrays(intArray,num26)==1) {

                                                                                                                    speakWords("This is Letter Z. You have completed learning English alphabet using braille");
                                                                                                                    nowinY = false;
                                                                                                                    nowinZ = true;
                                                                                                                    return true;

                                                                                                                }
                                                                                                                else if((compareArrays(intArray,num1)==-1))
                                                                                                                {
                                                                                                                    speakWords("Please enter the letter" );
                                                                                                                }
                                                                                                                else if ((compareArrays(intArray,num1)==-2))
                                                                                                                {
                                                                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter Z by giving first give single tap on the Top Left side, then single tap of Mid Right side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen " );

                                                                                                                }else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num26)) {
                                                                                                                    speakWords("Incorrect entry of Letter Z. Re enter letter Z by giving first give single tap on the Top Left side, then single tap of Mid Right side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen ");
                                                                                                                    mClickedButtonIds.clear();

                                                                                                                } else {
                                                                                                                    speakWords("Incorrect entry of Letter Y. Re enter letter Z by giving first give single tap on the Top Left side, then single tap of Mid Right side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                                }

                                                                                                            }
                                                                                                            else {

                                                                                                                if (!Arrays.equals(intArray, num0) && !Arrays.equals(intArray, num1) && !Arrays.equals(intArray, num2) && !Arrays.equals(intArray, num3) && !Arrays.equals(intArray, num4) && !Arrays.equals(intArray, num5) && !Arrays.equals(intArray, num6) && !Arrays.equals(intArray, num7) && !Arrays.equals(intArray, num8) && !Arrays.equals(intArray, num9) && !Arrays.equals(intArray, num10) && !Arrays.equals(intArray, num11) && !Arrays.equals(intArray, num12) && !Arrays.equals(intArray, num13) && !Arrays.equals(intArray, num14) && !Arrays.equals(intArray, num15) && !Arrays.equals(intArray, num16) && !Arrays.equals(intArray, num17) && !Arrays.equals(intArray, num18) && !Arrays.equals(intArray, num19) && !Arrays.equals(intArray, num20) && !Arrays.equals(intArray, num21) && !Arrays.equals(intArray, num22) && !Arrays.equals(intArray, num23) && !Arrays.equals(intArray, num24) && !Arrays.equals(intArray, num25) && !Arrays.equals(intArray, num26)) {

                                                                                                                    speakWords("invalid sign. Please enter correct sign of the letter");
                                                                                                                    return false;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onPause() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    public static int compareArrays(int[] array1, int[] array2) {

        if (array1 != null && array2 != null){
            if (array1.length != array2.length)
                return -1;
            else
                for (int i = 0; i < array2.length; i++) {
                    if (array2[i] != array1[i]) {

                        return -2;
                    }
                }
        }else{
            return -3;
        }
        return 1;
    }

}
