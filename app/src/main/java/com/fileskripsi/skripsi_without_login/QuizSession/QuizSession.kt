package com.fileskripsi.skripsi_without_login.QuizSession

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.rangeTo
import androidx.core.util.toRange
import com.fileskripsi.skripsi_without_login.*
import com.fileskripsi.skripsi_without_login.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_quiz_session.*
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt
import kotlin.math.sqrt


class quizSession : AppCompatActivity(), View.OnClickListener {
    private lateinit var database: FirebaseDatabase
    private lateinit var jumlahbtg: EditText
    private lateinit var LDl: EditText
    private lateinit var Tensi: EditText
    private lateinit var radioButtondata: RadioButton
    private lateinit var Submit: Button
    lateinit var chb: CheckBox
    lateinit var genderradio: RadioButton
    lateinit var genderradio1: RadioButton
    private lateinit var answerSheets1: MutableList<AnswerSheets>
    private lateinit var CF_list: MutableList<Cf_Class>
    private lateinit var CF_Data: MutableList<Cf_hitung>
    private lateinit var CF_Data1: MutableList<Cf_hitung>
    private lateinit var CF_Data2: MutableList<Cf_hitung>
    private lateinit var Cf_user: MutableList<nlist>
    private lateinit var berat_badan: EditText
    private lateinit var tinggi_badan: EditText
    private lateinit var Data_umur: EditText
    private lateinit var Gender: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_session)
        database = FirebaseDatabase.getInstance()
        question_List()
        //answer()
        // dbRef = database1?.reference!!.child("Data_Jawaban")
        answerSheets1 = mutableListOf()
        CF_list = mutableListOf()
        CF_Data = mutableListOf()
        CF_Data1 = mutableListOf()
        CF_Data2 = mutableListOf()
        Cf_user = mutableListOf()
        Submit = findViewById(R.id.Submitbutton)
        jumlahbtg = findViewById(R.id.jumlah)
        LDl = findViewById(R.id.ldl_score)
        Tensi = findViewById(R.id.Tensi)
        chb = findViewById(R.id.checkBox)

        Submit.setOnClickListener(this)


    }

    private fun question_List() {
        val ref = FirebaseDatabase.getInstance().getReference("/Database_Risk_Factor/Question")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
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
                for (data in snapshot.children) {
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
                Log.d("TAG", "Data error ")
            }

        })

    }


    private fun answerSheets_data() {
        jumlahbtg = findViewById(R.id.jumlah)
        LDl = findViewById(R.id.ldl_score)
        Tensi = findViewById(R.id.Tensi)
        chb = findViewById(R.id.checkBox)
        berat_badan = findViewById(R.id.beratbadan)
        tinggi_badan = findViewById(R.id.tinggibadan)
        Data_umur = findViewById(R.id.Umur)
        //Gender = findViewById(R.id.Gender)
        var Result = ""
        var dbansw = ""
        var data: Double
        var data1: Double
        var data2: Double
        var dataCombine: Double
        var dataCombine1: Double
        var dataCombine2: Double
        var dataCombine3: Double
        var dataCombine4: Double
        var dataCombine5: Double
        var dataCombine6: Double
        var dataCombine7: Double
        var dataCombine8: Double
        var dataCombine9: Double
        var dataCombine10: Double
        var dataCombine11: Double
        var dataCombine12: Double
        var dataCombine13: Double
        var dataCombine14: Double
        var dataCombine15: Double
        var dataCombine16: Double
        var dataCombine17: Double
        var dataCombine18: Double
        var dataCombine19: Double
        var dataCombine20: Double
        var dataCombine21: Double
        var dataCombine22: Double
        var dataCombine23: Double
        var dataCombine24: Double
        val result = StringBuilder()
        val result1 = StringBuilder()
        val result2 = StringBuilder()
        val result3 = StringBuilder()
        val result4 = StringBuilder()
        val ref = FirebaseDatabase.getInstance().getReference("User_ans")
        val nlistcfcombinerendah = mutableListOf<Double>()
        val nlistcfcombineSedang = mutableListOf<Double>()
        val nlistcfcombineTinggi = mutableListOf<Double>()
        val Nlist_combine = mutableListOf<Double>()
        var nlist = mutableListOf<Double>()
        val listCF_Rendah = listOf<Double>(0.8, 0.8, 0.8, 0.8, 0.8, -1.0, 1.0, 0.8, 1.0)
        val listCF_Sedang = listOf<Double>(0.4, 0.6, 0.6, 0.6, 1.0, -1.0, 1.0, 0.6, 0.6)
        val listCF_Tinggi = listOf<Double>(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0)




        if (chb.isChecked) {
            result.append("\nTidak")
            var A1 = 0.8

            nlist.add(A1)

            jumlahbtg.isEnabled = false
            //  nlistcfcombine.add()
        }
        //jumlah batang + cf

        val jumlah_batang = jumlahbtg.text.toString().toInt()

        if (jumlah_batang <= 10){
            var A2 = 0.4
            nlist.add(A2)
        }
        if (jumlah_batang >= 10) {
            var A3 = 1.0
            nlist.add(A3)
        }


        // ldl + CF
        val LDL = LDl.text.toString().toInt()
        if (LDL <= 75) {
            var A4 = 0.8
            nlist.add(A4)
        } else if (LDL in 75 rangeTo (150)) {
            val A5 = 0.6
            nlist.add(A5)
        } else if (LDL > 150) {
            val A6 = 1.0
            nlist.add(A6)
        }

        /// Tensi + CF
        val Data_Tensi = Tensi.text.toString().toInt()
        if (Data_Tensi <= 120) {
            val A7 = 0.8
            nlist.add(A7)
        } else if (Data_Tensi in 120 rangeTo (140)) {
            val A8 = 0.6
            nlist.add(A8)
        } else if (Data_Tensi > 140) {
            val A9 = 1.0
            nlist.add(A9)
        }

        // BErat Badan + cf
        val bb = berat_badan.text.toString().toDouble()
        val tinggi = tinggi_badan.text.toString().toDouble()
        val bmi = bb / tinggi / tinggi * 10000
        val bmi1 = bmi.roundToInt()
        if (bmi1.toDouble() in 18.5 rangeTo (24.9)) {
            val A10 = 0.8
            nlist.add(A10)

        } else if (bmi1.toDouble() in 25.0 rangeTo (29.9)) {
            val A11 = 0.6
            nlist.add(A11)
        } else if (bmi1.toDouble() in 30.00 rangeTo (34.9)) {
            val A12 = 1.0
            nlist.add(A12)
        }

        val dataumur = Data_umur.text.toString().toInt()
        if (dataumur <= 40) {
            val A13 = 0.8
            nlist.add(A13)
        } else if (dataumur in 40 rangeTo (50)) {
            val A14 = 0.6
            nlist.add(A14)
        } else if (dataumur > 50) {
            val A15 = 1.0
            nlist.add(A15)
        }
        // gender
        if (radioButton4.isChecked) {
            result1.append("Laki-laki")
            val A16 = 1.0
            nlist.add(A16)

        }
        if (radioButton5.isChecked) {
            result1.append("Perempuan")
            val A17 = -1.0
            nlist.add(A17)
        }
        //riwayat diabetes
        if (radioButton6.isChecked) {
            result2.append("Tidak")
            val A18 = 1.0
            nlist.add(A18)
        }
        if (radioButton7.isChecked) {
            result2.append("Ya")
            val A19 = -1.0
            nlist.add(A19)
        }

        // olahraga
        if (radioButton8.isChecked) {
            result3.append("Rutin")
            val A20 = 0.8
            nlist.add(A20)
        }
        if (radioButton9.isChecked) {
            result3.append("Jarang")
            val A21 = 0.6
            nlist.add(A21)
        }
        if (radioButton10.isChecked) {
            result3.append("Tidak")
            val A22 = 1.0
            nlist.add(A22)
        }

        // tingkat stress
        if (radioButton11.isChecked) {
            result4.append("Tidak")
            val A24 = 1.0
            nlist.add(A24)
        }
        if (radioButton12.isChecked) {
            result4.append("ya")
            val A23 = -1.0
            nlist.add(A23)
        }


        val taskid = ref.push().key
        val jawabanUser = AnswerSheets(result.toString(), jumlah_batang, LDL, Data_Tensi, bmi1.toDouble(),dataumur, result1.toString(),result2.toString(), result3.toString(), result4.toString())
        if (jawabanUser.Smoke == null) {
            AnswerSheets("", jumlah_batang, LDL, Data_Tensi,bmi1.toDouble(),dataumur,result1.toString(),  result2.toString(), result3.toString(),result4.toString())
        }
        answerSheets1.add(jawabanUser)

        val X = Cf_hitung(nlist[0],nlist[1],nlist[2],nlist[3],nlist[4],nlist[5],nlist[6],nlist[7],nlist[8])
        Log.d("Test", X.toString())
        Log.d("Test", nlist.toString())
        Log.d("Test", answerSheets1.toString())



        for (i in nlist.indices) {
            if (jawabanUser.Smoke =="Tidak") {
                for (j in listCF_Rendah.indices) {
                    data = nlist[i] * listCF_Rendah[j]
                    nlistcfcombinerendah.add(data)
                }
            }
            else if (jumlah_batang <= 10) {
                for (k in listCF_Sedang.indices) {
                    data1 = nlist[i] * listCF_Sedang[k]
                    nlistcfcombineSedang.add(data1)
                }
            }


        }
        if (nlistcfcombinerendah != null) {
            for (i in nlistcfcombinerendah.indices) {
                if (i in 0..9) {
                    dataCombine = nlistcfcombinerendah[0] + nlistcfcombinerendah[1] * (1 - nlistcfcombinerendah[0])
                    dataCombine1 = nlistcfcombinerendah[1] + dataCombine * (1 - nlistcfcombinerendah[1])
                    dataCombine2 = nlistcfcombinerendah[2] + dataCombine1 * (1 - nlistcfcombinerendah[2])
                    dataCombine3 = nlistcfcombinerendah[3] + dataCombine2 * (1 - nlistcfcombinerendah[3])
                    dataCombine4 = nlistcfcombinerendah[4] + dataCombine3 * (1 - nlistcfcombinerendah[4])
                    dataCombine5 = nlistcfcombinerendah[5] + dataCombine4 * (1 - nlistcfcombinerendah[5])
                    dataCombine6 = nlistcfcombinerendah[6] + dataCombine5 * (1 - nlistcfcombinerendah[6])
                    dataCombine7 = nlistcfcombinerendah[7] + dataCombine6 * (1 - nlistcfcombinerendah[7])
                    dataCombine8 = nlistcfcombinerendah[8] + dataCombine7 * (1 - nlistcfcombinerendah[8])
                    val x = Cf_Class(dataCombine, dataCombine1, dataCombine2, dataCombine3, dataCombine4, dataCombine5, dataCombine6, dataCombine7, dataCombine8)
                    val datalist = (x.cf1 + x.cf2 + x.cf3 + x.cf4 + x.cf5 + x.cf6 + x.cf7 + x.cf8 + x.cf9) / 9 * 100
                    datalist.roundToInt()
                    CF_list.add(x)
                    Log.d("CF_list", CF_list.toString())
                    Log.d("datalist", datalist.toString())
                }
            }
        }
        if (nlistcfcombineSedang.indices != null) {
            for (i in nlistcfcombineSedang.indices) {
                if (i == 0) {
                    dataCombine9 = nlistcfcombineSedang[0] + nlistcfcombineSedang[1] * (1 - nlistcfcombineSedang[0])
                    dataCombine10 = nlistcfcombineSedang[1] + dataCombine9 * (1 - nlistcfcombineSedang[1])
                    dataCombine11 = nlistcfcombineSedang[2] + dataCombine10 * (1 - nlistcfcombineSedang[2])
                    dataCombine12 = nlistcfcombineSedang[3] + dataCombine11 * (1 - nlistcfcombineSedang[3])
                    dataCombine13 = nlistcfcombineSedang[4] + dataCombine12 * (1 - nlistcfcombineSedang[4])
                    dataCombine14 = nlistcfcombineSedang[5] + dataCombine13 * (1 - nlistcfcombineSedang[5])
                    dataCombine15 = nlistcfcombineSedang[6] + dataCombine14 * (1 - nlistcfcombineSedang[6])
                    dataCombine16 = nlistcfcombineSedang[7] + dataCombine15 * (1 - nlistcfcombineSedang[7])
                    dataCombine17 = nlistcfcombineSedang[8] + dataCombine16 * (1 - nlistcfcombineSedang[8])
                    val x = Cf_Class(dataCombine9, dataCombine10, dataCombine11, dataCombine12, dataCombine13, dataCombine14, dataCombine15, dataCombine16, dataCombine17)
                    val datalist = (x.cf1 + x.cf2 + x.cf3 + x.cf4 + x.cf5 + x.cf6 + x.cf7 + x.cf8 + x.cf9) / 9 * 100
                    datalist.roundToInt()
                    CF_list.add(x)
                    Log.d("CF_list", CF_list.toString())
                    Log.d("datalist", datalist.toString())
                }
            }
        }

        /* if (taskid!=null) {
         ref.child(taskid).setValue(jawabanUser)
     }*/
    }


    override fun onClick(v: View?) {
        answerSheets_data()
    }


}