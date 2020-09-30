package com.chrisjaunes.android_teaching.database1.example;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Exp2Dao {
    @Insert
    public long[] insertUsers(Exp2UserEntity... users);

    @Update
    public int updateUsers(Exp2UserEntity... users);

    @Delete
    public int deleteUsers(Exp2UserEntity... users);

    @Query("SELECT * FROM Users")
    public List<Exp2UserEntity> queryAllUsers();

    @Query("SELECT * FROM Users WHERE age > :minAge")
    public List<Exp2UserEntity> loadAllUsersOlderThan(int minAge);
}