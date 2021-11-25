package com.example.dbdemo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        var helper= MyDBHelper(applicationContext)
        var db= helper.readableDatabase
        var lv=findViewById<ListView>(R.id.listview1)
        var rs=db.rawQuery("SELECT _id,UNAME,NAME,PWD,IS_ACTIVE FROM LOGIN",null)
        var adapter=SimpleCursorAdapter(applicationContext,
                                        //android.R.layout.simple_expandable_list_item_2,
                                        R.layout.mylayout,
                                        rs,
                                        arrayOf("NAME","UNAME","IS_ACTIVE"),
                                        intArrayOf(R.id.textView1,R.id.textView2,R.id.textView3),
                                        0)
        lv.adapter=adapter
    }
}