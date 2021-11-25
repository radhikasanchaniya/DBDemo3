package com.example.dbdemo3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) :SQLiteOpenHelper(context,"LoginDB",null,1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE LOGIN(_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, UNAME TEXT, PWD TEXT, IS_ACTIVE TEXT)")
        p0?.execSQL("INSERT INTO LOGIN(NAME,UNAME,PWD,IS_ACTIVE) VALUES('ADMIN','admin@au.com','admin123','yes')")
        p0?.execSQL("INSERT INTO LOGIN(NAME,UNAME,PWD,IS_ACTIVE) VALUES('Parag','parag@au.com','pcs123','yes')")
        p0?.execSQL("INSERT INTO LOGIN(NAME,UNAME,PWD,IS_ACTIVE) VALUES('Tatsat','tatsat@au.com','tatsat123','no')")


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}