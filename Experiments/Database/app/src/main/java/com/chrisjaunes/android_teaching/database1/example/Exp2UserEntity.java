package com.chrisjaunes.android_teaching.database1.example;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Exp2UserEntity {
    @PrimaryKey
    @NonNull
    public String name;

    @ColumnInfo(name = "age")
    public int age;

    public String phone;

    Exp2UserEntity(@NonNull String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}