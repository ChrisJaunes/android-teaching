package com.chrisjaunes.android_teaching.database1.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Exp1SQLiteOpenHelper extends SQLiteOpenHelper {
    static String SCHAME_NAME = "EXP1";
    static String TABLE_USER = "users";
    static String TABLE_USER_NAME = "name";
    static String TABLE_USER_AGE = "age";
    static String TABLE_USER_PHONE = "phone";
    static String TABLE_USER_CREATE = "create table users(name varchar(11), age int, phone varchar(15))";
    static Exp1SQLiteOpenHelper instance;

    static public Exp1SQLiteOpenHelper getInstance(@Nullable Context context, int schame_version) {
        if(null == instance) instance = new Exp1SQLiteOpenHelper(context, schame_version);
        return instance;
    }

    private Exp1SQLiteOpenHelper(@Nullable Context context, int schame_version) {
        super(context, SCHAME_NAME, null, schame_version);
        Log.d("Exp1", "Exp1SQLiteOpenHelper 结束调用 构造函数");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER_CREATE);
        Log.d("Exp1", "Exp1SQLiteOpenHelper 调用了 onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("Exp1", "Exp1SQLiteOpenHelper 调用了 onUpgrade");
    }
}
