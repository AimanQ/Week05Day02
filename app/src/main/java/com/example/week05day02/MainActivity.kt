package com.example.week05day02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var x:Int?= null
    private var buttonShow:Button?= null
    private var buttonSnack:Button?= null
    private var constraintLayout:ConstraintLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        handleExceptions()
        connectViews()
        showToast()
        showSnackbar()

    }
    private fun connectViews(){
        buttonShow = findViewById(R.id.btnShowToast)
        buttonSnack = findViewById(R.id.btnShowSnack)
        constraintLayout = findViewById(R.id.root)
    }
    private fun showToast(){
        buttonShow?.setOnClickListener {
            /*
            1) Context (this)
            2) Message
            3) Duration
            Don't forget to add .show()
             */
            Toast.makeText(this,"This is simple toast",Toast.LENGTH_SHORT).show()
        }
    }
    private fun showSnackbar(){
        /*
        1) Viewgroup (constraintLayout)
        2) Message
        3) Duration
        4) setAction("button name") Optional
        Don't forget to add .show()
         */

//        Snackbar.make(constraintLayout!!,"This is test snackbar"
//            ,Snackbar.LENGTH_INDEFINITE).setAction("Dismiss"){
//            Toast.makeText(this,"This is simple toast",Toast.LENGTH_SHORT).show()
//        }.show()
        buttonSnack?.setOnClickListener {
            Snackbar.make(constraintLayout!!,"This is sample snackbar",Snackbar.LENGTH_LONG).show()
        }


    }
    private fun handleExceptions(){
        try {
            val sum = x!! + 10
        }catch (e:NullPointerException){
            Log.e("ERROR_NULL","x can not be null")
        }

        try {
            val div = 10/0
        }catch (e:ArithmeticException){
            Log.e("ERROR_DIV","can not divide over 0")
        }

        val arr:ArrayList<String> = ArrayList()
        arr.add("Ahmad") //0
        arr.add("Khalid") //1
        arr.add("Ali") //2
        arr.add("Sarah") //3
        arr.add("Mohammed") //4

        try {
            val name = arr[5]
        }catch (e:IndexOutOfBoundsException){
            Log.e("ERROR_ARR","non existent index")
        }


    }
}