package com.fileskripsi.skripsi_without_login.QuizSession

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fileskripsi.skripsi_without_login.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_quiz_session.*
import java.lang.StringBuilder

class quizSession : AppCompatActivity() {
    var databaseReference :  DatabaseReference? = null
    var database: FirebaseDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_session)
        database = FirebaseDatabase.getInstance()


        val ref= FirebaseDatabase.getInstance().getReference("/Database_Risk_Factor/Question")
        ref.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var sb = StringBuilder()
                var sb1 = StringBuilder()
                var sb2 = StringBuilder()
                var sb3 = StringBuilder()
                var sb4 = StringBuilder()
                var sb5 = StringBuilder()
                var sb6 = StringBuilder()
                var sb7 = StringBuilder()
                var sb8 = StringBuilder()
                for (data in snapshot.children){
                if (data.child("ID_Question").getValue() == "Q1") {
                    var data1 = data.child("nama_Pertanyaan").getValue()
                    sb.append("$data1\n")
                }
                    if (data.child("ID_Question").getValue() == "Q2") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb1.append("$data1\n")
                    }
                    if (data.child("ID_Question").getValue() == "Q3") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb2.append("$data1\n")
                    }
                    if (data.child("ID_Question").getValue() == "Q4") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb3.append("$data1\n")
                    }
                    if (data.child("ID_Question").getValue() == "Q5") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb4.append("$data1\n")
                    }
                    if (data.child("ID_Question").getValue() == "Q6") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb5.append("$data1\n")
                    }
                    if (data.child("ID_Question").getValue() == "Q7") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb6.append("$data1\n")
                    }
                    if (data.child("ID_Question").getValue() == "Q8") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb7.append("$data1\n")
                    }
                    if (data.child("ID_Question").getValue() == "Q9") {
                        var data1 = data.child("nama_Pertanyaan").getValue()
                        sb8.append("$data1\n")
                    }
                }
                qustionno1.setText(sb)
                qustionno2.setText(sb1)
                question3.setText(sb2)
                question4.setText(sb3)
                question5.setText(sb4)
                question6.setText(sb5)
                question7.setText(sb6)
                question8.setText(sb7)
                question9.setText(sb8)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("TAG","Data error ")
            }

        })



    }
}