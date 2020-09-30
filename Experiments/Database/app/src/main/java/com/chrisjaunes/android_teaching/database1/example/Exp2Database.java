package com.chrisjaunes.android_teaching.database1.example;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Exp2UserEntity.class}, version = 1, exportSchema = false)
public abstract class Exp2Database extends RoomDatabase {
    public abstract Exp2Dao Exp2Dao();
}