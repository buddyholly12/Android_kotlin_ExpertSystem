    package com.fileskripsi.skripsi_without_login.QuizSession

    import android.os.Bundle
    import android.util.Log
    import android.view.View
    import android.widget.*
    import androidx.appcompat.app.AppCompatActivity
    import com.fileskripsi.skripsi_without_login.AnswerSheets
    import com.fileskripsi.skripsi_without_login.R
    import com.google.firebase.database.*
    import kotlinx.android.synthetic.main.activity_quiz_session.*


    class quizSession : AppCompatActivity(), View.OnClickListener {
        var databaseReference :  DatabaseReference? = null
        private lateinit var database: FirebaseDatabase
        private lateinit var jumlahbtg:EditText
        private lateinit var LDl :EditText
        private lateinit var Tensi :EditText
        private lateinit var radioButtondata: RadioButton
        private  lateinit var Submit :Button
        lateinit var  chb : CheckBox
        private lateinit var answerSheets1: MutableList<AnswerSheets>
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_quiz_session)
            database = FirebaseDatabase.getInstance()
            question_List()
            //answer()
            answerSheets1 = mutableListOf()
            Submit =findViewById(R.id.Submitbutton)
            jumlahbtg = findViewById(R.id.jumlah)
            LDl = findViewById(R.id.ldl_score)
            Tensi =findViewById(R.id.Tensi)
            chb = findViewById(R.id.checkBox)

            Submit.setOnClickListener(this)
            chb.setOnClickListener(this)

        }
        private  fun question_List(){
            val ref= FirebaseDatabase.getInstance().getReference("/Database_Risk_Factor/Question")
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


        private fun answerSheets_data(){
            jumlahbtg = findViewById(R.id.jumlah)
            LDl = findViewById(R.id.ldl_score)
            Tensi =findViewById(R.id.Tensi)
            chb = findViewById(R.id.checkBox)
            var Result =""
            var dbansw = ""
            val result = StringBuilder()
            val ref= FirebaseDatabase.getInstance().getReference("User_ans")
            if(chb.isChecked){
                result.append("\nTidak")
                jumlahbtg.isEnabled =false
            }
            val jumlah_batang = jumlahbtg.text.toString().trim()
            val LDL = LDl.text.toString().trim()
            val Data_Tensi = Tensi.text.toString().trim()
            val jawabanUser = AnswerSheets(result.toString(),jumlah_batang,LDL,Data_Tensi)
            answerSheets1.add(jawabanUser)


            Log.d("Test",answerSheets1.toString())


        }

        fun no_1(){


        }

        override fun onClick(v: View?) {
            no_1()
            answerSheets_data()


        }

        /*  private fun answer(){
              answerSheets1 = mutableListOf()
             // val no1: Int = no1.checkedRadioButtonId
              //val rb = resources.getResourceEntryName(no1)
              val ref1= database.getReference("/Database_Risk_Factor/Answer_score")
              ref1.addListenerForSingleValueEvent(object:ValueEventListener{
                  var sb = StringBuilder()
                  override fun onDataChange(snapshot: DataSnapshot) {
                      for (data in snapshot.children) {
                          if (data.child("ID_Question").getValue() == "Q1") {
                              if (data.child("ID_jawaban").getValue()== "A1"){
                                 // val x = rb.toString()



                                  var data1 = data.child("nama_Jawaban").getValue()
                                  sb.append("$data1\n")
                                  var dbans = AnswerSheets(data1.toString())
                                  answerSheets1.add(dbans)
                                  Log.d("Test",answerSheets1.toString())
                              }
                          }

                      }

                  }

                  override fun onCancelled(error: DatabaseError) {
                      Log.d("TAG", "Data error ")
                  }

              })
          }
          */
    }