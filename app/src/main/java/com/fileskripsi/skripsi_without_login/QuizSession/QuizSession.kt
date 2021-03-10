package com.fileskripsi.skripsi_without_login.QuizSession

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.rangeTo
import androidx.core.view.isGone
import androidx.databinding.DataBindingUtil
import com.fileskripsi.skripsi_without_login.*
import com.fileskripsi.skripsi_without_login.R
import com.fileskripsi.skripsi_without_login.databinding.ActivityQuizSessionBinding
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_quiz_session.*
import kotlin.math.roundToInt


class quizSession : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {
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
    private lateinit var CF_list1: MutableList<Double>
    private lateinit var CF_Data: MutableList<Cf_hitung>
    private lateinit var CF_Data1: MutableList<Cf_hitung>
    private lateinit var CF_Data2: MutableList<Cf_hitung>
    private lateinit var Cf_user: MutableList<CF_data>
    private lateinit var berat_badan: EditText
    private lateinit var tinggi_badan: EditText
    private lateinit var Data_umur: EditText
    private lateinit var Spinners :Spinner
    private lateinit var  binding: ActivityQuizSessionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_session)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_quiz_session)
        database = FirebaseDatabase.getInstance()
        question_List()
        //answer()
        // dbRef = database1?.reference!!.child("Data_Jawaban")
        answerSheets1 = mutableListOf()
        CF_list = mutableListOf()
        CF_list1 = mutableListOf()
        CF_Data = mutableListOf()
        CF_Data1 = mutableListOf()
        CF_Data2 = mutableListOf()
        Cf_user = mutableListOf()
        Submit = findViewById(R.id.Submitbutton)
        jumlahbtg = findViewById(R.id.jumlah)
        LDl = findViewById(R.id.ldl_score)
        Tensi = findViewById(R.id.Tensi)
        chb = findViewById(R.id.checkBox)
        Spinners =findViewById(R.id.spinner)
        Submit.setOnClickListener(this)
      //  Spinners?.onItemSelectedListener(this)


     Cf_data()




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
        var dataCombine25: Double
        var dataCombine26: Double
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

            jumlahbtg.isGone = true
            //  nlistcfcombine.add()
        }

        //jumlah batang + cf
        val jumlah_batang = jumlahbtg.text.toString().trim()
        if (jumlah_batang.isEmpty()) {
            jumlahbtg.isGone = true
        } else {
            if (jumlah_batang.toInt() <= 10) {
                var A2 = 0.4
                nlist.add(A2)
            }
            if (jumlah_batang.toInt() >= 10) {
                var A3 = 1.0
                nlist.add(A3)
            }
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
        } else if (Data_Tensi >= 140) {
            val A9 = 1.0
            nlist.add(A9)
        }

        // BErat Badan + cf
        val bb = berat_badan.text.toString().toDouble()
        val tinggi = tinggi_badan.text.toString().toDouble()
        val bmi = bb / tinggi / tinggi * 10000
        val bmi1 = bmi.roundToInt()
        Log.d("bmi",bmi.toString())
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
        } else if (dataumur >= 50) {
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
//        val X = Cf_hitung(nlist[0], nlist[1], nlist[2], nlist[3], nlist[4], nlist[5], nlist[6], nlist[7], nlist[8])
//        Log.d("Test", X.toString())
//        Log.d("Test", nlist.toString())
        Log.d("Test", answerSheets1.toString())






        
    }

    private fun Data_Rendah(usr_ans: String, usr_ans1: String, usr_ans2: Int, usr_ans3: Int, usr_ans4: Double, usr_ans5: Int, usr_ans6: String, usr_ans7: String, usr_ans8: String, usr_ans9: Double) {

        var sb = StringBuilder()

        var flag = true
        if (usr_ans == "Tidak" && usr_ans6 == "Perempuan") {
            flag
        }else if (usr_ans2 <= 75 && usr_ans3 <= 120) {
            flag
        } else if (usr_ans4 in 18.5 rangeTo (24.9) && usr_ans5 <= 40) {
            flag
        } else if (usr_ans6 == "Rutin" && usr_ans7 == "Tidak") {
            flag
        } else if (usr_ans8 == "Tidak" && usr_ans9 <= 98.0) {
            flag
            Log.d("error", "anda memiliki resiko rendah  ")

        }else {
            Log.d("error", "jawaban anda kurang sesuai ")
        }


        // Log.d("error",flag.toString())


    }


    override fun onClick(v: View?) {
        answerSheets_data()
    }

    private fun Cf_data(){
        val flag = true
        //val cfUser = listOf<Double>(0.0,0.4,0.6,0.8)
        var nlist = mutableListOf<Double>()
        val Cf_datauser = resources.getStringArray(R.array.CF_Data)

        val arrayAdapter = ArrayAdapter(this@quizSession,android.R.layout.simple_spinner_dropdown_item,Cf_datauser)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = this
        spinner2.adapter = arrayAdapter
        spinner2.onItemSelectedListener = this
        spinner3.adapter =arrayAdapter
        spinner3.onItemSelectedListener = this
        spinner4.adapter =arrayAdapter
        spinner4.onItemSelectedListener = this
        spinner5.adapter =arrayAdapter
        spinner5.onItemSelectedListener = this
        spinner6.adapter =arrayAdapter
        spinner6.onItemSelectedListener = this
        spinner7.adapter =arrayAdapter
        spinner7.onItemSelectedListener = this
        spinner8.adapter =arrayAdapter
        spinner8.onItemSelectedListener = this
        spinner9.adapter =arrayAdapter
        spinner9.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val cf1 = binding?.spinner?.selectedItem.toString()
        val cf2 = binding?.spinner2?.selectedItem.toString()
        val cf3 = binding?.spinner3?.selectedItem.toString()
        val cf4 = binding?.spinner4?.selectedItem.toString()
        val cf5 = binding?.spinner5?.selectedItem.toString()
        val cf6 = binding?.spinner6?.selectedItem.toString()
        val cf7 = binding?.spinner7?.selectedItem.toString()
        val cf8 = binding?.spinner8?.selectedItem.toString()
        val cf9 = binding?.spinner9?.selectedItem.toString()
        cfCount(cf1.toDouble(),cf2.toDouble(),cf3.toDouble(),cf4.toDouble(),cf5.toDouble(),cf6.toDouble(),cf7.toDouble(),cf8.toDouble(),cf9.toDouble())
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    private fun cfCount(cf1:Double,cf2: Double,cf3:Double,cf4: Double,cf5:Double,cf6: Double,cf7:Double,cf8: Double,cf9: Double){
        val x = CF_Val.Cf_data(cf1,cf2,cf3, cf4, cf5, cf6, cf7, cf8, cf9)
        val comp = x.component1()
        Log.d("Check Data1",x.toString())
       // Log.d("Check CF ", CF_Val.database().toString())


    }
}





