package com.fileskripsi.skripsi_without_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fileskripsi.skripsi_without_login.QuizSession.quizSession
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener{
            val intent = Intent(this@MainActivity,quizSession::class.java)
            startActivity(intent)
        }

    }

}