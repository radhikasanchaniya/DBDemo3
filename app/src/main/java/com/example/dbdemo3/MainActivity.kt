package com.example.dbdemo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var edName=findViewById<EditText>(R.id.edName)
        var edPwd=findViewById<EditText>(R.id.edPwd)
        var btnLogin=findViewById<Button>(R.id.button)
        var helper = MyDBHelper(applicationContext)
        var db= helper.readableDatabase

        btnLogin.setOnClickListener {
            var rs = db.rawQuery(
                "SELECT * FROM LOGIN WHERE UNAME= ? AND PWD = ?",
                arrayOf(edName.text.toString(), edPwd.text.toString())
            )
            if (rs.moveToFirst()) {
                var active = rs.getString(4)
                if (active.equals("yes")) {
                    Toast.makeText(
                        applicationContext,
                        "Welcome! You are authenticated User",
                        Toast.LENGTH_LONG
                    ).show()
                    if (edName.text.toString().equals("admin@au.com")) {
                        var intent = Intent(applicationContext, AdminActivity::class.java)
                        startActivity(intent)
                    }
                }else
                        Toast.makeText(
                            applicationContext,
                            "Your Login is not Approved by admin",
                            Toast.LENGTH_LONG
                        ).show()
                } else {
                    Toast.makeText(applicationContext, "Invalid Credentials", Toast.LENGTH_LONG)
                        .show()
                }


            }

            //var rs = db.rawQuery("SELECT * FROM LOGIN",null)
//        if(rs.moveToFirst()){
//            Toast.makeText(applicationContext,rs.getString(1),Toast.LENGTH_LONG).show()
//        }


        }
}