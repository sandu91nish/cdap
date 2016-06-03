package com.teachme_module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PC PAL on 5/29/2016.
 */
public class DbHelperClass {
    public static final String QUZ_ID = "id";
    public static final String QUZ_NAME = "name";
    public static final String QU_ANS="answer";


    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "QuestionDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String QUIZ_TABLE = "QueDB_tb";

    private static final String CREATE_QUIZ_TABLE =
            "create table "
                    + QUIZ_TABLE + " (" + QUZ_ID + " integer primary key unique, " + QUZ_NAME + " text not null,"+QU_ANS+" text not null)";


    private final Context mCtx;

    private static class DatabaseHelper extends
            SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null,
                    DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_QUIZ_TABLE);
        }

        public void onUpgrade(SQLiteDatabase db, int
                oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " +
                    QUIZ_TABLE);
            onCreate(db);
        }
    }

    public void Reset() {
        mDbHelper.onUpgrade(this.mDb, 1, 1);
    }

    public DbHelperClass(Context ctx) {
        mCtx = ctx;
        mDbHelper = new DatabaseHelper(mCtx);
    }

    public DbHelperClass open() throws SQLException {
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public void insertQuzDetails(Questions quz) {
        ContentValues cv = new ContentValues();

        cv.put(QUZ_ID, quz.getQuzId());
        cv.put(QUZ_NAME, quz.getQuz());
        cv.put(QU_ANS, quz.getAns());

        mDb.insert(QUIZ_TABLE, null, cv);
    }


    public Questions retrieveQuzDetails() throws
            SQLException {

        Cursor cur = mDb.query(true, QUIZ_TABLE, new
                        String[]{
                        QUZ_ID, QUZ_NAME,QU_ANS}, null, null, null, null,
                null, null);

        if (cur.moveToFirst()) {

            int qu_id = cur.getColumnIndex(QUZ_ID.toString());
            String qu_name = cur.getString
                    (cur.getColumnIndex(QUZ_NAME));
            String qu_ans = cur.getString
                    (cur.getColumnIndex(QU_ANS));

            cur.close();
            return new Questions(qu_id, qu_name,qu_ans);
        }
        cur.close();
        return null;
    }

    public Cursor getQuz(int id) {

        Cursor res = null;
        Cursor cur = mDb.query(true, QUIZ_TABLE, new
                        String[]{
                        QUZ_ID, QUZ_NAME,QU_ANS}, null, null, null, null,
                null, null);

        if (cur.moveToFirst()) {

       //     int qu_id = cur.getColumnIndex(QUZ_ID.toString());
            int newId = id+1;
            res =  mDb.rawQuery( "select name from QueDB_tb where id="+newId+"", null );

         //   res =  mDb.rawQuery( "SELECT name FROM Question_tb ORDER BY RANDOM() LIMIT 15", null );


        }

        return res;

    }

//    public Cursor getRowRandom() {
//        Cursor c =  mDb.rawQuery("SELECT * FROM Question_tb ORDER BY RANDOM() LIMIT 10", null);
//        if (c != null) {
//            c.moveToFirst();
//        }
//        return c;
//    }

    public String[] getAnswers(int id)
    {


        Cursor res = null;

            int newId = id+1;

            res =  mDb.rawQuery( "select answer from QueDB_tb where id="+newId+"", null );


            res.moveToFirst();

            ArrayList<String> answers = new ArrayList<String>();

            while(!res.isAfterLast()) {
                answers.add(res.getString(res.getColumnIndex("answer")));
                res.moveToNext();
            }


        String [] status=answers.toArray(new String[answers.size()]);


        return status;


    }

    private void processLine(String[] strings) {
        Integer[] intarray=new Integer[strings.length];
        int i=0;
        for(String str:strings){
            intarray[i]=Integer.parseInt(str.trim());//Exception in this line
            i++;
        }
    }
}
