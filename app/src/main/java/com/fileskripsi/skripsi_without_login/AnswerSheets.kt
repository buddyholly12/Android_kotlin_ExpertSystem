package com.fileskripsi.skripsi_without_login

data class AnswerSheets(val Smoke:String,val smoke_qty:String, val Ldl:Int,val Tensi:Int,val Gender:String,val bmi : Double
,val diabetes :String,val Sport : String,val Umur : Int,val stressval :String) {
    constructor():this("","",0,0,"",0.0,"","",0,""){

    }
}