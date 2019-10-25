package com.example.line.Base

import android.os.Bundle
import androidx.fragment.app.Fragment

 abstract class BaseFragment: Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
   super.onCreate(savedInstanceState)
   initView()
  }


  open protected fun initView(){

  }
}