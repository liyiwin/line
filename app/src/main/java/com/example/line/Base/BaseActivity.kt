package com.example.line.Base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.line.R
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

  open protected  fun initData(){

    }



    open protected  fun initListener(){

    }






    protected fun myToast(msg: String) {

        runOnUiThread { Toast.makeText(this, msg, Toast.LENGTH_LONG).show() }
    }


}