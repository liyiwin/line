package com.example.line

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.line.model.ImageModel




class Adapter2 (val context: Context,private var item : MutableList<ImageModel>): RecyclerView.Adapter<Adapter2.ViewHolder>(){

    //在類別建構子加上第三個參數，命名為 itemClickEvent，型態是接收 ImageModel 的 lambda 表示式

    val itemList:MutableList<ImageModel> = ArrayList()

    // itemClickListnerImp －> ItemClickListener 實作接口傳進來
    var itemClickListnerImp: ItemClickListener? = null



    interface ItemClickListener {
        fun itemClick( item : ImageModel)
    }

    //用來讓 activity 或 fragment  實作 interface 的function

    fun setOnItemClick(itemClickListner: ItemClickListener){
        itemClickListnerImp = itemClickListner
    }


    override fun onBindViewHolder(holder: Adapter2.ViewHolder, position: Int) {

      holder.bind(item[position], context)

    }

    override fun getItemCount(): Int = item.size

    //VIEWHOLDER IS INITIALIZED

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.row2, parent, false)
        return ViewHolder(view)


    }




    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //內部類別 Holder 加入屬性來做之前 findView 的工作
       val title = view.findViewById<TextView>(R.id.title2)
        val text=view.findViewById<TextView>(R.id.text2)
        val pp=view.findViewById<TextView>(R.id.pp2)
        val time=view.findViewById<TextView>(R.id.time2)
        val image=view.findViewById<ImageView>(R.id.image2)
        val checkBox=view.findViewById<CheckBox>(R.id.checkBox)

        //另外建立一個 bind() 方法，此方法負責將清單項目的圖片及文字指定到屬性物件上。(上)
        fun bind(group:ImageModel, context: Context){


           title.text=item[position].title
           text.text=item[position].text
           time.text=item[position].time
            pp.text=item[position].pp
            image.setImageResource(item[position].image)
            checkBox.isChecked = item[position].isSelected //  讓recyclerview不會重複
            //itemView.setOnClickListener { itemClickEvent(group) }


            //當點擊的時候（itemClick()）, 執行interface實作
            checkBox.setOnClickListener {
                itemClickListnerImp?.itemClick(group)
            }

        }




    }


    fun removeData(position:Int ){
        item.remove(item[position]);
        //删除动画
        notifyItemRemoved(position);
        notifyDataSetChanged();

    }


  fun update(newList: MutableList<ImageModel>){

        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }





}