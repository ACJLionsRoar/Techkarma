package com.example.aswin_000.techkarma;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HighScoresDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    public String CREATE_QUERY = "CREATE TABLE "+ HighScoresDatabase2.TableData.TableInfo.TABLE_NAME+"("+ HighScoresDatabase2.TableData.TableInfo.USER_NAME+" TEXT,"+ HighScoresDatabase2.TableData.TableInfo.USER_SCORE+" TEXT );";

    public HighScoresDBHelper(Context context) {
        super(context, HighScoresDatabase2.TableData.TableInfo.DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created");
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0,int arg1,int arg2)
    {

    }

    public void addinfo(HighScoresDBHelper hsop,String name,String score)
    {

            SQLiteDatabase SQ=hsop.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put(HighScoresDatabase2.TableData.TableInfo.USER_NAME,name);
            cv.put(HighScoresDatabase2.TableData.TableInfo.USER_SCORE,score);
            SQ.insert(HighScoresDatabase2.TableData.TableInfo.TABLE_NAME, null, cv);
            Log.d("Database operations", "1 raw inserted");


    }

    public Cursor getinfo(HighScoresDBHelper hsop)
    {
        SQLiteDatabase SQ= hsop.getReadableDatabase();
        String[] coloumns= {HighScoresDatabase2.TableData.TableInfo.USER_NAME, HighScoresDatabase2.TableData.TableInfo.USER_SCORE};
        Cursor CR=SQ.query(HighScoresDatabase2.TableData.TableInfo.TABLE_NAME,coloumns,null,null,null,null, HighScoresDatabase2.TableData.TableInfo.USER_SCORE+" DESC");
        return CR;
    }

    public void updateinfo(HighScoresDBHelper hsop,String name,String newscore){
        SQLiteDatabase SQ=hsop.getWritableDatabase();
        String selection= HighScoresDatabase2.TableData.TableInfo.USER_NAME+" LIKE ?";
        String args[]={name};
        ContentValues values=new ContentValues();
        values.put(HighScoresDatabase2.TableData.TableInfo.USER_SCORE,newscore);
        SQ.update(HighScoresDatabase2.TableData.TableInfo.TABLE_NAME, values, selection, args);

    }

    public void deleteinfo(HighScoresDBHelper hsop)
    {

        SQLiteDatabase SQ=hsop.getWritableDatabase();
        SQ.execSQL("DELETE FROM " + HighScoresDatabase2.TableData.TableInfo.TABLE_NAME);

    }
}




