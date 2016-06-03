package com.teachme_module;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class InsertandRetriveData extends Activity implements View.OnClickListener {

    public int quizId;
    TextToSpeech tts;
    boolean isStarted, successA = false;
    boolean nowinA, nowinB, nowinC, nowinD, nowinE, nowinF, nowinG, nowinH, nowinI, nowinJ, nowinK, nowinL, nowinM, nowinN, nowinO, nowinP, nowinQ, nowinR, nowinS, nowinT, nowinU, nowinV, nowinW, nowinX, nowinY, nowinZ = false;
    DbHelperClass helper = new DbHelperClass(this);
    private DbHelperClass DbHelper;
    private List<Integer> mClickedButtonIds = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertand_retrive_blob_data);

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


        DbHelper = new DbHelperClass(this);

        Questions quz_One = new Questions(1, "Type the first letter of word Cat", "10,20");
        Questions quz_Two = new Questions(2, "Type the first letter of word Apple", "10");
        Questions quz_Three = new Questions(3, "Type the first letter of word Ball", "10,30");
        Questions quz_Four = new Questions(4, "Type the first letter of word Dog", "10,20,40");
        Questions quz_Five = new Questions(5, "Type the first letter of word Egg", "10,40");
        Questions quz_Six = new Questions(6, "Type the first letter of word Fan", "10,20,30");
        Questions quz_Seven = new Questions(7, "Type the first letter of word Gun", "10,20,30,40");
        Questions quz_Eight = new Questions(8, "Type the first letter of word Hat", "10, 30, 40");
        Questions quz_Nine = new Questions(9, "Type the first letter of word Ice cream", "20, 30");
        Questions quz_Ten = new Questions(10, "Type the first letter of word Jug", "20, 30, 40");
        Questions quz_Eleven = new Questions(11, "Type the first letter of word Kite", "10, 50");
        Questions quz_Tweleve = new Questions(12, "Type the first letter of word Lamp", "10, 30, 50");
        Questions quz_Thirteen = new Questions(13, "Type the first letter of word Mango", "10, 20, 50");
        Questions quz_Fourteen = new Questions(14, "Type the first letter of word Nest", "10, 20, 40, 50");
        Questions quz_Fifteen = new Questions(15, "Type the first letter of word Ocean", "10, 40, 50");
        Questions quz_Sixteen = new Questions(16, "Type the first letter of word Pineapple", "10, 20, 30, 50");
        Questions quz_Seventeen = new Questions(17, "Type the first letter of word Queen", "10, 20, 30, 40, 50");
        Questions quz_Eighteen = new Questions(18, "Type the first letter of word Rat", "10, 30,40, 50");
        Questions quz_Nineteen = new Questions(19, "Type the first letter of word Sun", "20, 30, 50");
        Questions quz_Twenty = new Questions(20, "Type the first letter of word Table", "20, 30, 40, 50");


        DbHelper.open();

        DbHelper.insertQuzDetails(quz_One);
        DbHelper.insertQuzDetails(quz_Two);
        DbHelper.insertQuzDetails(quz_Three);
        DbHelper.insertQuzDetails(quz_Four);
        DbHelper.insertQuzDetails(quz_Five);
        DbHelper.insertQuzDetails(quz_Six);
        DbHelper.insertQuzDetails(quz_Seven);
        DbHelper.insertQuzDetails(quz_Eight);
        DbHelper.insertQuzDetails(quz_Nine);
        DbHelper.insertQuzDetails(quz_Ten);
        DbHelper.insertQuzDetails(quz_Eleven);
        DbHelper.insertQuzDetails(quz_Tweleve);
        DbHelper.insertQuzDetails(quz_Thirteen);
        DbHelper.insertQuzDetails(quz_Fourteen);
        DbHelper.insertQuzDetails(quz_Fifteen);
        DbHelper.insertQuzDetails(quz_Sixteen);
        DbHelper.insertQuzDetails(quz_Seventeen);
        DbHelper.insertQuzDetails(quz_Eighteen);
        DbHelper.insertQuzDetails(quz_Nineteen);
        DbHelper.insertQuzDetails(quz_Twenty);


        DbHelper.close();

        DbHelper.open();

        quz_One = DbHelper.retrieveQuzDetails();

        quizId = quz_One.getQuzId();

        DbHelper.close();


        Thread logoTimer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    speakWords("Hi guys...");
                    sleep(2000);
                    speakWords("you are in Tutor module");
                    sleep(5000);
                    speakWords("Lets start on check the knowledge of english letters you have learned ");
                    sleep(5000);

                    helper.open();

                    Cursor cursor = helper.getQuz(quizId);

                    if (cursor.moveToFirst())

                        speakWords("First question is " + cursor.getString(cursor.getColumnIndex("name")));


                    String[] result = helper.getAnswers(quizId);

                    if (cursor.moveToFirst()) {

                        String[] array = result[0].split(",");
                        System.out.println("results[0] = "+result[0]);
                        int[] arr = new int[array.length];

                        for (int i = 0; i < array.length; i++) {
                            System.out.println("arr - "+i+" = "+arr[i]+" array - "+i+" = "+array[i]);
                            arr[i] = Integer.parseInt(array[i]);
                            System.out.println("arr - "+i+" = "+arr[i]+" array - "+i+" = "+array[i]);

                        }

                        System.out.print(arr);

                        for(int i=0;i<= arr.length;i++)
                        {

                            if ((arr.length) > i + 1)
                                System.out.print(arr[i] + ",");
                            else
                                System.out.print(arr[i]);

                            int[] num2 = new int[]{10, 20};

                            if (Arrays.equals(arr, num2)) {
                                speakWords("success");
                                System.out.print(num2);

                            }
                        }


                        boolean status = false;


//


                        quizId++;

                        cursor.close();

                        helper.close();

                        nowinA = true;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        logoTimer.start();

    }

    private void speakWords(String speech) {

        if (tts != null) {
            tts.setSpeechRate(0.8f);
            tts.setPitch(1.0f);
            tts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public boolean CheckSpelling(List<Integer> number) {
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


        //    Arrays.sort(intArray);


        if (intArray == null) {
            System.out.println("Please enter the letter");
            return true;

        }

        if (nowinA) {
            if (compareArrays(intArray, num1) == 1) {

                helper.open();

                Cursor cursor = helper.getQuz(quizId);
                quizId++;

                if (cursor.moveToFirst())

                    speakWords("Correct Answer. " + cursor.getString(cursor.getColumnIndex("name")));

                cursor.close();

                helper.close();
                nowinA = false;
                nowinB = true;


                return true;


            } else if ((compareArrays(intArray, num1) == -1)) {
                speakWords("Please enter the letter");
            } else if ((compareArrays(intArray, num1) == -2)) {
                speakWords("Order of entering taps of the letter is in incorrect. Please re enter Letter A by giving a single tap on the top left side of the screen ");

            } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                speakWords("Incorrect entry of Letter A. Re enter Letter A by giving a single tap on the top left side of the screen");
                mClickedButtonIds.clear();

            } else {
                speakWords("Incorrect entry of Letter A. Re enter Letter A by giving a single tap on the top left side of the screen");
                mClickedButtonIds.clear();
            }
        } else {
            if (nowinB) {


                if (compareArrays(intArray, num2) == 1) {

                    helper.open();

                    Cursor cursor = helper.getQuz(quizId);
                    quizId++;

                    if (cursor.moveToFirst())

                        speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                    cursor.close();

                    helper.close();
                    nowinB = false;
                    nowinC = true;
                    return true;


                } else if ((compareArrays(intArray, num2) == -1)) {
                    speakWords("Please enter the letter");
                } else if ((compareArrays(intArray, num2) == -2)) {
                    speakWords("Order of entering taps of the letter is in incorrect. Please re enter letter B by giving single tap on the Top Left side and then single tap on the Mid Left side of the screen");

                } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                    speakWords("Incorrect entry of Letter B. Re enter letter B by giving single tap on the Top Left side and then single tap on the Mid Left side of the screen");
                    mClickedButtonIds.clear();

                } else {
                    speakWords("Incorrect entry of Letter B. Re enter letter B by giving single tap on the Top Left side and then single tap on the Mid Left side of the screen");
                    mClickedButtonIds.clear();
                }
            } else {
                if (nowinC) {
                    if (compareArrays(intArray, num3) == 1) {

                        helper.open();

                        Cursor cursor = helper.getQuz(quizId);
                        quizId++;

                        if (cursor.moveToFirst())

                            speakWords("Correct answer" + cursor.getString(cursor.getColumnIndex("name")));

                        cursor.close();

                        helper.close();
                        nowinC = false;
                        nowinD = true;
                        return true;


                    } else if ((compareArrays(intArray, num3) == -1)) {
                        speakWords("Please enter the letter");
                    } else if ((compareArrays(intArray, num3) == -2)) {
                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter C by giving first single tap on Top Left side and then give single tap on the Top Right side of the screen");

                    } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                        speakWords("Incorrect entry of Letter C. Re enter letter C by giving first single tap on Top Left side and then give single tap on the Top Right side of the screen");
                        mClickedButtonIds.clear();

                    } else {
                        speakWords("Incorrect entry of Letter C. Re enter letter C by giving first single tap on Top Left side and then give single tap on the Top Right side of the screen");
                        mClickedButtonIds.clear();
                    }
                } else {
                    if (nowinD) {
                        if (compareArrays(intArray, num4) == 1) {

                            helper.open();

                            Cursor cursor = helper.getQuz(quizId);
                            quizId++;

                            if (cursor.moveToFirst())

                                speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                            cursor.close();

                            helper.close();
                            nowinD = false;
                            nowinE = true;
                            return true;


                        } else if ((compareArrays(intArray, num4) == -1)) {
                            speakWords("Please enter the letter");
                        } else if ((compareArrays(intArray, num4) == -2)) {
                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter D by giving first single tap on Top Left side,then single tap on the Top Right side and finally single tap on the Mid Right side of the screen");

                        } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                            speakWords("Incorrect entry of Letter D. Re enter letter D by giving first single tap on Top Left side,then single tap on the Top Right side and finally single tap on the Mid Right side of the screen");
                            mClickedButtonIds.clear();

                        } else {
                            speakWords("Incorrect entry of Letter D. Re enter letter D by giving first single tap on Top Left side,then single tap on the Top Right side and finally single tap on the Mid Right side of the screen");
                            mClickedButtonIds.clear();
                        }
                    } else {

                        if (nowinE) {
                            if (compareArrays(intArray, num5) == 1) {

                                helper.open();

                                Cursor cursor = helper.getQuz(quizId);
                                quizId++;

                                if (cursor.moveToFirst())

                                    speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                cursor.close();

                                helper.close();
                                nowinE = false;
                                nowinF = true;
                                return true;

                            } else if ((compareArrays(intArray, num5) == -1)) {
                                speakWords("Please enter the letter");
                            } else if ((compareArrays(intArray, num5) == -2)) {
                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter E by giving first give single tap on the Top Left side, then single tap on Mid Right side of the screen");

                            } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                speakWords("Incorrect entry of Letter E. Re enter letter E by giving first give single tap on the Top Left side, then single tap on Mid Right side of the screen");
                                mClickedButtonIds.clear();

                            } else {
                                speakWords("Incorrect entry of Letter E. Re enter letter E by giving first give single tap on the Top Left side, then single tap on Mid Right side of the screen");
                                mClickedButtonIds.clear();
                            }

                        } else {

                            if (nowinF) {
                                if (compareArrays(intArray, num6) == 1) {

                                    helper.open();

                                    Cursor cursor = helper.getQuz(quizId);
                                    quizId++;

                                    if (cursor.moveToFirst())

                                        speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                    cursor.close();

                                    helper.close();
                                    nowinF = false;
                                    nowinG = true;
                                    return true;

                                } else if ((compareArrays(intArray, num6) == -1)) {
                                    speakWords("Please enter the letter");
                                } else if ((compareArrays(intArray, num6) == -2)) {
                                    speakWords("Order of entering taps of the letter is in incorrect. Please re enter letter F by giving first give single tap on the Top Left side, then single tap of Top Right side and finally give single tap on Mid Left of the screen");

                                } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                    speakWords("Incorrect entry of Letter F. Re enter letter F by giving first give single tap on the Top Left side, then single tap of Top Right side and finally give single tap on Mid Left of the screen");
                                    mClickedButtonIds.clear();

                                } else {
                                    speakWords("Incorrect entry of Letter F. Re enter letter F by giving first give single tap on the Top Left side, then single tap of Top Right side and finally give single tap on Mid Left of the screen");
                                    mClickedButtonIds.clear();
                                }

                            } else {
                                if (nowinG) {
                                    if (compareArrays(intArray, num7) == 1) {

                                        helper.open();

                                        Cursor cursor = helper.getQuz(quizId);
                                        quizId++;

                                        if (cursor.moveToFirst())

                                            speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                        cursor.close();

                                        helper.close();
                                        nowinG = false;
                                        nowinH = true;
                                        return true;

                                    } else if ((compareArrays(intArray, num7) == -1)) {
                                        speakWords("Please enter the letter");
                                    } else if ((compareArrays(intArray, num7) == -2)) {
                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");

                                    } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                        speakWords("Incorrect entry of Letter G. Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                        mClickedButtonIds.clear();

                                    } else {
                                        speakWords("Incorrect entry of Letter G. Re enter letter G by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid left side and finally give single tap on Mid Right of the screen");
                                        mClickedButtonIds.clear();
                                    }

                                } else {
                                    if (nowinH) {
                                        if (compareArrays(intArray, num8) == 1) {

                                            helper.open();

                                            Cursor cursor = helper.getQuz(quizId);
                                            quizId++;

                                            if (cursor.moveToFirst())

                                                speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                            cursor.close();

                                            helper.close();
                                            nowinH = false;
                                            nowinI = true;
                                            return true;

                                        } else if ((compareArrays(intArray, num8) == -1)) {
                                            speakWords("Please enter the letter");
                                        } else if ((compareArrays(intArray, num8) == -2)) {
                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter H by giving first give single tap on the Top Left side, then single tap on Mid Left and finally single tap on Mid Right side of the screen");

                                        } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                            speakWords("Incorrect entry of Letter H. Re enter letter H by giving first give single tap on the Top Left side, then single tap on Mid Left and finally single tap on Mid Right side of the screen");
                                            mClickedButtonIds.clear();

                                        } else {
                                            speakWords("Incorrect entry of Letter H. Re enter letter H by giving first give single tap on the Top Left side, then single tap on Mid Left and finally single tap on Mid Right side of the screen");
                                            mClickedButtonIds.clear();
                                        }

                                    } else {
                                        if (nowinI) {
                                            if (compareArrays(intArray, num9) == 1) {

                                                helper.open();

                                                Cursor cursor = helper.getQuz(quizId);
                                                quizId++;

                                                if (cursor.moveToFirst())

                                                    speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                cursor.close();

                                                helper.close();
                                                nowinI = false;
                                                nowinJ = true;
                                                return true;

                                            } else if ((compareArrays(intArray, num9) == -1)) {
                                                speakWords("Please enter the letter");
                                            } else if ((compareArrays(intArray, num9) == -2)) {
                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter I by giving first give single tap on the Top Right side, then single tap of Mid Left side of the screen");

                                            } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                speakWords("Incorrect entry of Letter I. Re enter letter I by giving first give single tap on the Top Right side, then single tap of Mid Left side of the screen");
                                                mClickedButtonIds.clear();

                                            } else {
                                                speakWords("Incorrect entry of Letter I. Re enter letter I by giving first give single tap on the Top Right side, then single tap of Mid Left side of the screen");
                                                mClickedButtonIds.clear();
                                            }

                                        } else {

                                            if (nowinJ) {
                                                if (compareArrays(intArray, num10) == 1) {

                                                    helper.open();

                                                    Cursor cursor = helper.getQuz(quizId);
                                                    quizId++;

                                                    if (cursor.moveToFirst())

                                                        speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                    cursor.close();

                                                    helper.close();
                                                    nowinJ = false;
                                                    nowinK = true;
                                                    return true;

                                                } else if ((compareArrays(intArray, num10) == -1)) {
                                                    speakWords("Please enter the letter");
                                                } else if ((compareArrays(intArray, num10) == -2)) {
                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter J by giving first give single tap on the Top Right side, then single tap of Mid Left side, finally give single tap on Mid Right of the screen");

                                                } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                    speakWords("Incorrect entry of Letter J. Re enter letter J by giving first give single tap on the Top Right side, then single tap of Mid Left side, finally give single tap on Mid Right of the screen");
                                                    mClickedButtonIds.clear();

                                                } else {
                                                    speakWords("Incorrect entry of Letter J. Re enter letter J by giving first give single tap on the Top Right side, then single tap of Mid Left side, finally give single tap on Mid Right of the screen");
                                                }

                                            } else {
                                                if (nowinK) {
                                                    if (compareArrays(intArray, num11) == 1) {

                                                        helper.open();

                                                        Cursor cursor = helper.getQuz(quizId);
                                                        quizId++;

                                                        if (cursor.moveToFirst())

                                                            speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                        cursor.close();

                                                        helper.close();
                                                        nowinK = false;
                                                        nowinL = true;
                                                        return true;

                                                    } else if ((compareArrays(intArray, num11) == -1)) {
                                                        speakWords("Please enter the letter");
                                                    } else if ((compareArrays(intArray, num11) == -2)) {
                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter K by giving first give single tap on the Top Left side, then single tap of Bottom Left side of the screen");

                                                    } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                        speakWords("Incorrect entry of Letter K. Re enter letter K by giving first give single tap on the Top Left side, then single tap of Bottom Left side of the screen");
                                                        mClickedButtonIds.clear();

                                                    } else {
                                                        speakWords("Incorrect entry of Letter K. Re enter letter K by giving first give single tap on the Top Left side, then single tap of Bottom Left side of the screen");
                                                    }

                                                } else {
                                                    if (nowinL) {
                                                        if (compareArrays(intArray, num12) == 1) {

                                                            helper.open();

                                                            Cursor cursor = helper.getQuz(quizId);
                                                            quizId++;

                                                            if (cursor.moveToFirst())

                                                                speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                            cursor.close();

                                                            helper.close();
                                                            nowinL = false;
                                                            nowinM = true;
                                                            return true;

                                                        } else if ((compareArrays(intArray, num12) == -1)) {
                                                            speakWords("Please enter the letter");
                                                        } else if ((compareArrays(intArray, num12) == -2)) {
                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter L by giving first give single tap on the Top Left side, then single tap of Mid Left side and finally single tap on the Bottom Left of the screen");

                                                        } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                            speakWords("Incorrect entry of Letter L. Re enter letter L by giving first give single tap on the Top Left side, then single tap of Mid Left side and finally single tap on the Bottom Left of the screen");
                                                            mClickedButtonIds.clear();

                                                        } else {
                                                            speakWords("Incorrect entry of Letter L. Re enter letter L by giving first give single tap on the Top Left side, then single tap of Mid Left side and finally single tap on the Bottom Left of the screen");
                                                        }

                                                    } else {
                                                        if (nowinM) {
                                                            if (compareArrays(intArray, num13) == 1) {

                                                                helper.open();

                                                                Cursor cursor = helper.getQuz(quizId);
                                                                quizId++;

                                                                if (cursor.moveToFirst())

                                                                    speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                cursor.close();

                                                                helper.close();
                                                                nowinM = false;
                                                                nowinN = true;
                                                                return true;

                                                            } else if ((compareArrays(intArray, num13) == -1)) {
                                                                speakWords("Please enter the letter");
                                                            } else if ((compareArrays(intArray, num13) == -2)) {
                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side and finally single tap on the Bottom Right of the screen");

                                                            } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                speakWords("Incorrect entry of Letter M. Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side and finally single tap on the Bottom Right of the screen");
                                                                mClickedButtonIds.clear();

                                                            } else {
                                                                speakWords("Incorrect entry of Letter M. Re enter letter M by giving first give single tap on the Top Left side, then single tap of Top Right side and finally single tap on the Bottom Right of the screen");
                                                            }

                                                        } else {
                                                            if (nowinN) {
                                                                if (compareArrays(intArray, num14) == 1) {

                                                                    helper.open();

                                                                    Cursor cursor = helper.getQuz(quizId);
                                                                    quizId++;

                                                                    if (cursor.moveToFirst())

                                                                        speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                    cursor.close();

                                                                    helper.close();
                                                                    nowinN = false;
                                                                    nowinO = true;
                                                                    return true;

                                                                } else if ((compareArrays(intArray, num14) == -1)) {
                                                                    speakWords("Please enter the letter");
                                                                } else if ((compareArrays(intArray, num14) == -2)) {
                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter N by giving first give single tap on the Top Left side, then single tap of Top Right side,then single tap on Mid Right and finally single tap on the Bottom Left of the screen");

                                                                } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                    speakWords("Incorrect entry of Letter N. Re enter letter N by giving first give single tap on the Top Left side, then single tap of Top Right side,then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                    mClickedButtonIds.clear();

                                                                } else {
                                                                    speakWords("Incorrect entry of Letter N. Re enter letter N by giving first give single tap on the Top Left side, then single tap of Top Right side,then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                }

                                                            } else {
                                                                if (nowinO) {
                                                                    if (compareArrays(intArray, num15) == 1) {

                                                                        helper.open();

                                                                        Cursor cursor = helper.getQuz(quizId);
                                                                        quizId++;

                                                                        if (cursor.moveToFirst())

                                                                            speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                        cursor.close();

                                                                        helper.close();
                                                                        nowinO = false;
                                                                        nowinP = true;
                                                                        return true;

                                                                    } else if ((compareArrays(intArray, num15) == -1)) {
                                                                        speakWords("Please enter the letter");
                                                                    } else if ((compareArrays(intArray, num15) == -2)) {
                                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter O by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");

                                                                    } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                        speakWords("Incorrect entry of Letter O. Re enter letter O by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                        mClickedButtonIds.clear();

                                                                    } else {
                                                                        speakWords("Incorrect entry of Letter O. Re enter letter O by giving first give single tap on the Top Left side, then single tap of Mid Right side, and finally single tap on the Bottom Left of the screen");
                                                                    }

                                                                } else {
                                                                    if (nowinP) {
                                                                        if (compareArrays(intArray, num16) == 1) {

                                                                            helper.open();

                                                                            Cursor cursor = helper.getQuz(quizId);
                                                                            quizId++;

                                                                            if (cursor.moveToFirst())

                                                                                speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                            cursor.close();

                                                                            helper.close();
                                                                            nowinQ = false;
                                                                            nowinR = true;
                                                                            return true;

                                                                        } else if ((compareArrays(intArray, num16) == -1)) {
                                                                            speakWords("Please enter the letter");
                                                                        } else if ((compareArrays(intArray, num16) == -2)) {
                                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter P by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left and finally single tap on the Bottom Left of the screen");

                                                                        } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                            speakWords("Incorrect entry of Letter P. Re enter letter P by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left and finally single tap on the Bottom Left of the screen");
                                                                            mClickedButtonIds.clear();

                                                                        } else {
                                                                            speakWords("Incorrect entry of Letter P. Re enter letter P by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left and finally single tap on the Bottom Left of the screen");
                                                                        }


                                                                    } else {
                                                                        if (nowinQ) {
                                                                            if (compareArrays(intArray, num17) == 1) {

                                                                                helper.open();

                                                                                Cursor cursor = helper.getQuz(quizId);
                                                                                quizId++;

                                                                                if (cursor.moveToFirst())

                                                                                    speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                cursor.close();

                                                                                helper.close();
                                                                                nowinQ = false;
                                                                                nowinR = true;
                                                                                return true;

                                                                            } else if ((compareArrays(intArray, num17) == -1)) {
                                                                                speakWords("Please enter the letter");
                                                                            } else if ((compareArrays(intArray, num17) == -2)) {
                                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter Q by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");

                                                                            } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                speakWords("Incorrect entry of Letter Q. Re enter letter Q by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                                mClickedButtonIds.clear();

                                                                            } else {
                                                                                speakWords("Incorrect entry of Letter Q. Re enter letter Q by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Left, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                            }

                                                                        } else {
                                                                            if (nowinR) {
                                                                                if (compareArrays(intArray, num18) == 1) {

                                                                                    helper.open();

                                                                                    Cursor cursor = helper.getQuz(quizId);
                                                                                    quizId++;

                                                                                    if (cursor.moveToFirst())

                                                                                        speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                    cursor.close();

                                                                                    helper.close();
                                                                                    nowinR = false;
                                                                                    nowinS = true;
                                                                                    return true;

                                                                                } else if ((compareArrays(intArray, num18) == -1)) {
                                                                                    speakWords("Please enter the letter");
                                                                                } else if ((compareArrays(intArray, num18) == -2)) {
                                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter R by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right, then single tap on Bottom Left of the screen");

                                                                                } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                    speakWords("Incorrect entry of Letter R. Re enter letter R by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right, then single tap on Bottom Left of the screen");
                                                                                    mClickedButtonIds.clear();

                                                                                } else {
                                                                                    speakWords("Incorrect entry of Letter R. Re enter letter R by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right, then single tap on Bottom Left  of the screen");
                                                                                }

                                                                            } else {
                                                                                if (nowinS) {
                                                                                    if (compareArrays(intArray, num19) == 1) {

                                                                                        helper.open();

                                                                                        Cursor cursor = helper.getQuz(quizId);
                                                                                        quizId++;

                                                                                        if (cursor.moveToFirst())

                                                                                            speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                        cursor.close();

                                                                                        helper.close();
                                                                                        nowinS = false;
                                                                                        nowinT = true;
                                                                                        return true;

                                                                                    } else if ((compareArrays(intArray, num19) == -1)) {
                                                                                        speakWords("Please enter the letter");
                                                                                    } else if ((compareArrays(intArray, num19) == -2)) {
                                                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter S by giving first give single tap on the Top Right side, then single tap of Mid Left side, and finally single tap on the Bottom Left side of the screen");

                                                                                    } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                        speakWords("Incorrect entry of Letter S. Re enter letter S by giving first give single tap on the Top Right side, then single tap of Mid Left side, and finally single tap on the Bottom Left side of the screen");
                                                                                        mClickedButtonIds.clear();

                                                                                    } else {
                                                                                        speakWords("Incorrect entry of Letter S. Re enter letter S by giving first give single tap on the Top Right side, then single tap of Mid Left side, and finally single tap on the Bottom Left side of the screen");
                                                                                    }

                                                                                } else {
                                                                                    if (nowinT) {
                                                                                        if (compareArrays(intArray, num20) == 1) {

                                                                                            helper.open();

                                                                                            Cursor cursor = helper.getQuz(quizId);
                                                                                            quizId++;

                                                                                            if (cursor.moveToFirst())

                                                                                                speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                            cursor.close();

                                                                                            helper.close();
                                                                                            nowinT = false;
                                                                                            nowinU = true;
                                                                                            return true;

                                                                                        } else if ((compareArrays(intArray, num20) == -1)) {
                                                                                            speakWords("Please enter the letter");
                                                                                        } else if ((compareArrays(intArray, num20) == -2)) {
                                                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter T by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");

                                                                                        } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                            speakWords("Incorrect entry of Letter T. Re enter letter T by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                                            mClickedButtonIds.clear();

                                                                                        } else {
                                                                                            speakWords("Incorrect entry of Letter T. Re enter letter T by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Left of the screen");
                                                                                        }


                                                                                    } else {
                                                                                        if (nowinU) {
                                                                                            if (compareArrays(intArray, num21) == 1) {

                                                                                                helper.open();

                                                                                                Cursor cursor = helper.getQuz(quizId);
                                                                                                quizId++;

                                                                                                if (cursor.moveToFirst())

                                                                                                    speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                                cursor.close();

                                                                                                helper.close();
                                                                                                nowinU = false;
                                                                                                nowinV = true;
                                                                                                return true;

                                                                                            } else if ((compareArrays(intArray, num21) == -1)) {
                                                                                                speakWords("Please enter the letter");
                                                                                            } else if ((compareArrays(intArray, num21) == -2)) {
                                                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter U by giving first give single tap on the Top Left side, then single tap of Bottom Left side, finally single tap on the Bottom Right of the screen");

                                                                                            } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                speakWords("Incorrect entry of Letter U. Re enter letter U by giving first give single tap on the Top Left side, then single tap of Bottom Left side, finally single tap on the Bottom Right of the screen");
                                                                                                mClickedButtonIds.clear();

                                                                                            } else {
                                                                                                speakWords("Incorrect entry of Letter U. Re enter letter U by giving first give single tap on the Top Left side, then single tap of Bottom Left side, finally single tap on the Bottom Right of the screen");
                                                                                            }

                                                                                        } else {
                                                                                            if (nowinV) {
                                                                                                if (compareArrays(intArray, num22) == 1) {

                                                                                                    helper.open();

                                                                                                    Cursor cursor = helper.getQuz(quizId);
                                                                                                    quizId++;

                                                                                                    if (cursor.moveToFirst())

                                                                                                        speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                                    cursor.close();

                                                                                                    helper.close();
                                                                                                    nowinV = false;
                                                                                                    nowinW = true;
                                                                                                    return true;

                                                                                                } else if ((compareArrays(intArray, num22) == -1)) {
                                                                                                    speakWords("Please enter the letter");
                                                                                                } else if ((compareArrays(intArray, num22) == -2)) {
                                                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter V by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");

                                                                                                } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                    speakWords("Incorrect entry of Letter V. Re enter letter V by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                    mClickedButtonIds.clear();

                                                                                                } else {
                                                                                                    speakWords("Incorrect entry of Letter V. Re enter letter V by giving first give single tap on the Top Left side, then single tap of Mid Left side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                }

                                                                                            } else {
                                                                                                if (nowinW) {
                                                                                                    if (compareArrays(intArray, num23) == 1) {

                                                                                                        helper.open();

                                                                                                        Cursor cursor = helper.getQuz(quizId);
                                                                                                        quizId++;

                                                                                                        if (cursor.moveToFirst())

                                                                                                            speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                                        cursor.close();

                                                                                                        helper.close();
                                                                                                        nowinW = false;
                                                                                                        nowinX = true;
                                                                                                        return true;

                                                                                                    } else if ((compareArrays(intArray, num23) == -1)) {
                                                                                                        speakWords("Please enter the letter");
                                                                                                    } else if ((compareArrays(intArray, num23) == -2)) {
                                                                                                        speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter W by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");

                                                                                                    } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                        speakWords("Incorrect entry of Letter W. Re enter letter W by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                        mClickedButtonIds.clear();

                                                                                                    } else {
                                                                                                        speakWords("Incorrect entry of Letter W. Re enter letter W by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                    }

                                                                                                } else {
                                                                                                    if (nowinX) {
                                                                                                        if (compareArrays(intArray, num24) == 1) {

                                                                                                            helper.open();

                                                                                                            Cursor cursor = helper.getQuz(quizId);
                                                                                                            quizId++;

                                                                                                            if (cursor.moveToFirst())

                                                                                                                speakWords("Correct Answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                                            cursor.close();

                                                                                                            helper.close();
                                                                                                            nowinX = false;
                                                                                                            nowinY = true;
                                                                                                            return true;

                                                                                                        } else if ((compareArrays(intArray, num24) == -1)) {
                                                                                                            speakWords("Please enter the letter");
                                                                                                        } else if ((compareArrays(intArray, num24) == -2)) {
                                                                                                            speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter X by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");

                                                                                                        } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num25) && Arrays.equals(intArray, num26)) {
                                                                                                            speakWords("Incorrect entry of Letter X. Re enter letter X by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen ");
                                                                                                            mClickedButtonIds.clear();

                                                                                                        } else {
                                                                                                            speakWords("Incorrect entry of Letter X. Re enter letter X by giving first give single tap on the Top Right side, then single tap of Mid Left side, then single tap on Mid Right and finally single tap on the Bottom Right side of the screen");
                                                                                                        }

                                                                                                    } else {
                                                                                                        if (nowinY) {
                                                                                                            if ((compareArrays(intArray, num25)) == 1) {

                                                                                                                helper.open();

                                                                                                                Cursor cursor = helper.getQuz(quizId);
                                                                                                                quizId++;

                                                                                                                if (cursor.moveToFirst())

                                                                                                                    speakWords("Correct answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                                                cursor.close();

                                                                                                                helper.close();
                                                                                                                nowinY = false;
                                                                                                                nowinZ = true;
                                                                                                                return true;

                                                                                                            } else if ((compareArrays(intArray, num25) == -1)) {
                                                                                                                speakWords("Please enter the letter");
                                                                                                            } else if ((compareArrays(intArray, num25) == -2)) {
                                                                                                                speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter Y by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Right ,then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");

                                                                                                            } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num26)) {
                                                                                                                speakWords("Incorrect entry of Letter Y. Re enter letter Y by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Right ,then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen ");
                                                                                                                mClickedButtonIds.clear();

                                                                                                            } else {
                                                                                                                speakWords("Incorrect entry of Letter Y. Re enter letter Y by giving first give single tap on the Top Left side, then single tap of Top Right side, then single tap on Mid Right ,then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                            }

                                                                                                        } else {
                                                                                                            if (nowinZ) {
                                                                                                                if (compareArrays(intArray, num26) == 1) {

                                                                                                                    helper.open();

                                                                                                                    Cursor cursor = helper.getQuz(quizId);
                                                                                                                    quizId++;

                                                                                                                    if (cursor.moveToFirst())

                                                                                                                        speakWords("Correct answer" + cursor.getString(cursor.getColumnIndex("name")));

                                                                                                                    cursor.close();

                                                                                                                    helper.close();
                                                                                                                    nowinZ = false;
                                                                                                                    return true;

                                                                                                                } else if ((compareArrays(intArray, num26) == -1)) {
                                                                                                                    speakWords("Please enter the letter");
                                                                                                                } else if ((compareArrays(intArray, num26) == -2)) {
                                                                                                                    speakWords("Order of entering taps of the letter is in incorrect. Please Re enter letter Z by giving first give single tap on the Top Left side, then single tap of Mid Right side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen ");

                                                                                                                } else if (Arrays.equals(intArray, num0) && Arrays.equals(intArray, num1) && Arrays.equals(intArray, num2) && Arrays.equals(intArray, num3) && Arrays.equals(intArray, num4) && Arrays.equals(intArray, num5) && Arrays.equals(intArray, num6) && Arrays.equals(intArray, num7) && Arrays.equals(intArray, num8) && Arrays.equals(intArray, num9) && Arrays.equals(intArray, num10) && Arrays.equals(intArray, num11) && Arrays.equals(intArray, num12) && Arrays.equals(intArray, num13) && Arrays.equals(intArray, num14) && Arrays.equals(intArray, num15) && Arrays.equals(intArray, num16) && Arrays.equals(intArray, num17) && Arrays.equals(intArray, num18) && Arrays.equals(intArray, num19) && Arrays.equals(intArray, num20) && Arrays.equals(intArray, num21) && Arrays.equals(intArray, num22) && Arrays.equals(intArray, num23) && Arrays.equals(intArray, num24) && Arrays.equals(intArray, num26)) {
                                                                                                                    speakWords("Incorrect entry of Letter Z. Re enter letter Z by giving first give single tap on the Top Left side, then single tap of Mid Right side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen ");
                                                                                                                    mClickedButtonIds.clear();

                                                                                                                } else {
                                                                                                                    speakWords("Incorrect entry of Letter Y. Re enter letter Z by giving first give single tap on the Top Left side, then single tap of Mid Right side, then single tap on Bottom Left and finally single tap on the Bottom Right side of the screen");
                                                                                                                }

                                                                                                            } else {

                                                                                                                if (!Arrays.equals(intArray, num0) && !Arrays.equals(intArray, num1) && !Arrays.equals(intArray, num2) && !Arrays.equals(intArray, num3) && !Arrays.equals(intArray, num4) && !Arrays.equals(intArray, num5) && !Arrays.equals(intArray, num6) && !Arrays.equals(intArray, num7) && !Arrays.equals(intArray, num8) && !Arrays.equals(intArray, num9) && !Arrays.equals(intArray, num10) && !Arrays.equals(intArray, num11) && !Arrays.equals(intArray, num12) && !Arrays.equals(intArray, num13) && !Arrays.equals(intArray, num14) && !Arrays.equals(intArray, num15) && !Arrays.equals(intArray, num16) && !Arrays.equals(intArray, num17) && !Arrays.equals(intArray, num18) && !Arrays.equals(intArray, num19) && !Arrays.equals(intArray, num20) && !Arrays.equals(intArray, num21) && !Arrays.equals(intArray, num22) && !Arrays.equals(intArray, num23) && !Arrays.equals(intArray, num24) && !Arrays.equals(intArray, num25) && !Arrays.equals(intArray, num26)) {

                                                                                                                    speakWords("invalid sign. Please enter the correct sign of the letter");
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
    public void onClick(View view) {
        if (!isStarted) {
            isStarted = true;
            mClickedButtonIds.add(view.getId());
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            isStarted = false;

                            CheckSpelling(mClickedButtonIds);


                            mClickedButtonIds.clear();

                        }
                    },
                    3000);

        } else {
            mClickedButtonIds.add(view.getId());
        }

    }

    public static int compareArrays(int[] array1, int[] array2) {

        int status = 1;


        if (array1.length != 0 && array2.length != 0)

        {
            if (array1.length != array2.length) {
                status = -1;
            } else {
                for (int i = 0; i < array2.length; i++) {
                    if (array2[i] != array1[i]) {
                        status = -2;
                        break;
                    }
                }
            }
        } else {
            status = -3;
        }
        return status;
    }
}
