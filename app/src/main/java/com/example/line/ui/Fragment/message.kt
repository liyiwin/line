package com.example.line.ui.Fragment


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.line.Adapter

import com.example.line.R
import com.example.line.Service.DataService
import kotlinx.android.synthetic.main.fragment_message.*

/**
 * A simple [Fragment] subclass.
 */
class message : Fragment() {

    private lateinit var adapter: Adapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        generateRecycleView()

//        val users=mutableListOf<ImageModel>()
//        for (i in 0..50){
//            users.add( ImageModel("松果","1234","09:10","5",R.drawable.k1))
//            users.add( ImageModel("Line Today","5678","15:11","40",R.drawable.k2))
//            users.add( ImageModel("Line Music","1244","13:45","9",R.drawable.k3))
//            users.add( ImageModel("生活市集","hello","09:07","54",R.drawable.k4))
//            users.add( ImageModel("瘋狂邦尼","我討厭你","16:17","43",R.drawable.k5))
//            users.add( ImageModel("小三美日","跟你說一個秘密ㄛ","21:55","30",R.drawable.k6))
//            users.add( ImageModel("煩人的貓咪","呵呵","17:17","17",R.drawable.k7))
//            users.add( ImageModel("豆卡","說拉","14:08","99",R.drawable.k8png))
//            users.add( ImageModel("Misa","吼你又來了","16:17","41",R.drawable.k9))
//            users.add( ImageModel("白爛貓","說謊","18:36","28",R.drawable.k10))
//            users.add( ImageModel("史蒂奇","明天要交報告","04:13","1",R.drawable.k11))
//
//
//        }

        // recyclerView.apply{
        //    layoutManager=LinearLayoutManager(context)
        //    adapter=Adapter(DataService. groups)

    }


    fun generateRecycleView() {
        adapter= Adapter(context!!,DataService.groups)
        recyclerView.adapter=adapter
        recyclerView  .layoutManager = LinearLayoutManager(context)
           }


}




