package com.example.line

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.line.model.ImageModel


class Adapter(val context: Context,private val item : MutableList<ImageModel>):RecyclerView.Adapter<Adapter.ViewHolder>(){



    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.bind(item[position], context)

    }

    override fun getItemCount(): Int = item.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.title)
        val text=view.findViewById<TextView>(R.id.text)
        val pp=view.findViewById<TextView>(R.id.pp)
        val time=view.findViewById<TextView>(R.id.time)
        val image=view.findViewById<ImageView>(R.id.image)

        //另外建立一個 bind() 方法，此方法負責將清單項目的圖片及文字指定到屬性物件上。(上)
        fun bind(group:ImageModel, context: Context){
            title.text=item[position].title
            text.text=item[position].text
            time.text=item[position].time
            pp.text=item[position].pp
            image.setImageResource(item[position].image)

        }




    }

 }

