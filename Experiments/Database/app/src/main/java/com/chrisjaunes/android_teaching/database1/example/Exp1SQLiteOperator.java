package com.chrisjaunes.android_teaching.database1.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Exp1SQLiteOperator {
    private SQLiteDatabase db;
    Exp1SQLiteOperator(Context context) {
        Log.d("Exp1", "Exp1DBHelper 调用了构造函数");
        Exp1SQLiteOpenHelper dbHelper = Exp1SQLiteOpenHelper.getInstance(context, 1);
        Log.d("Exp1", "Exp1DBHelper 调用了 Exp1SQLiteOpenHelper 的 getReadableDatabase");
        db = dbHelper.getReadableDatabase();
    }
    long insert(String name, int age, String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Exp1SQLiteOpenHelper.TABLE_USER_NAME, name);
        contentValues.put(Exp1SQLiteOpenHelper.TABLE_USER_AGE, age);
        contentValues.put(Exp1SQLiteOpenHelper.TABLE_USER_PHONE, phone);
        return db.insert(Exp1SQLiteOpenHelper.TABLE_USER, null, contentValues);
    }
    int update(String name, int age, String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Exp1SQLiteOpenHelper.TABLE_USER_AGE, age);
        contentValues.put(Exp1SQLiteOpenHelper.TABLE_USER_PHONE, phone);
        String[] args = {name};
        return db.update(Exp1SQLiteOpenHelper.TABLE_USER, contentValues, Exp1SQLiteOpenHelper.TABLE_USER_NAME + " = ? ", args);
    }
    int delete(String name) {
        String[] args = {name};
        return db.delete(Exp1SQLiteOpenHelper.TABLE_USER, Exp1SQLiteOpenHelper.TABLE_USER_NAME + " = ? ", args);
    }

    List<Exp1UserEntity> queryAll() {
        List<Exp1UserEntity> res = new ArrayList<>();
        Cursor cursor = db.query(Exp1SQLiteOpenHelper.TABLE_USER, null,null, null, null, null,null);
        if(cursor.moveToFirst()) {
            do{
                Exp1UserEntity user = new Exp1UserEntity();
                user.name = cursor.getString(cursor.getColumnIndex("name"));
                user.age = Integer.parseInt(cursor.getString(cursor.getColumnIndex("age")));
                user.phone = cursor.getString(cursor.getColumnIndex("phone"));
                res.add(user);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return res;
    }










}
