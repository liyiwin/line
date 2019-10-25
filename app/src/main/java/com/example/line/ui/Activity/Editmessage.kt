package com.example.line.ui.Activity

import android.content.ClipData
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.line.Adapter2
import com.example.line.R
import com.example.line.Service.DataService
import com.example.line.model.ImageModel
import com.example.line.model.itemList
import com.example.line.ui.Fragment.message

import kotlinx.android.synthetic.main.activity_editmessage.*
import kotlinx.android.synthetic.main.activity_editmessage.view.*
import kotlinx.android.synthetic.main.row2.*
import kotlinx.android.synthetic.main.toolbar.*

class Editmessage : AppCompatActivity() {

    private lateinit var adapter: Adapter2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editmessage)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow)
        this.setTitle("編輯聊天訊息列表")
        toolbar.setTitleTextColor(Color.WHITE)

    //  Adapter2.update(itemList)



       // recyclerView2.apply{
         //   layoutManager= LinearLayoutManager(context)
       //     adapter=Adapter2(DataService.users)
      //  }

        generateRecycleView()


    }


    fun generateRecycleView() {

        adapter= Adapter2(this,DataService.groups)
        //{
          //  Toast.makeText(this, "Click", Toast.LENGTH_LONG).show()
        //}
        recyclerView2.adapter=adapter


        //在這裡實作 interface   匿名物件

        adapter.setOnItemClick(object : Adapter2.ItemClickListener {
            override fun itemClick(item :ImageModel) {
                item.isSelected = !item.isSelected


            }

        })

        tabItem.setOnClickListener {
            val delete = itemList.filter { it.isSelected == true }
            delete.forEach { itemList.remove(it) }
            //Adapter2.update
        }

        recyclerView2.layoutManager=LinearLayoutManager(this)

     }


//
}

