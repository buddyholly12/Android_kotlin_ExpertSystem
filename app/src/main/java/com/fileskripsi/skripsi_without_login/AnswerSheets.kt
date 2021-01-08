package com.fileskripsi.skripsi_without_login

data class AnswerSheets(val Smoke:String,val smoke_qty:String, val Ldl:String,val Tensi:String,val Gender:String,val bmi : Int) {
    constructor():this("","","","","",0){

    }
}