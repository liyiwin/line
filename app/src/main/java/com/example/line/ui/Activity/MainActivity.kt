package com.example.line.ui.Activity

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import com.example.line.Base.BaseActivity
import com.example.line.R
import com.example.line.model.itemList
import com.example.line.ui.Fragment.*
import com.example.line.util.toolbarManage
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tabview.view.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity(), toolbarManage {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        toolbar.setTitle(MainData.mainToolbartitle[0])
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.inflateMenu(R.menu.menu2)
        toolbar.setOnMenuItemClickListener {

         when(it.itemId){
             R.id.edit -> {
                 var intent =  Intent(this,Editmessage::class.java)
                 this.startActivity(intent)
             }
             R.id.sequence -> {
                 val list_sort = arrayOf("收到時間","未讀訊息","我的最愛")
                 AlertDialog.Builder(this).setItems(list_sort){dialog,i->
                     //顯示被點選的項目


                 } .show()
             }
             R.id.mark -> {
                 val build = AlertDialog.Builder(this)
                 build.setTitle("要將所有訊息標為已讀嗎？")
                 build.setPositiveButton("標為已讀",{dialog, which ->

                 })
                 build.setNegativeButton("取消",    {dialog, which -> })
                 val dialog =build.create()
                 dialog.show()
             }



         }
         true


        }

        initView()
    }

   private fun initView(){
       tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
           override fun onTabSelected(p0: TabLayout.Tab?) {

               toolbar.getMenu().clear()

                onTabItemSelected(p0!!.position)

               for (a in 0 until tabLayout.tabCount) {

                   val view = tabLayout.getTabAt(a)!!.customView

                   if (a == p0.position) {

                       view?.tab_content_image?.setImageResource(MainData.mainTabResPressed[a])
                       view?.tab_content_text?.setTextColor(
                           ContextCompat.getColor(
                               this@MainActivity,
                               android.R.color.black
                           )
                       )
                       view?.setBackgroundResource(R.color.mistyrose)
                       toolbar.inflateMenu(MainData.mainmenu[a])
                       toolbar.setTitle(MainData.mainToolbartitle[a])
                   } else {
                       view?.tab_content_image?.setImageResource(MainData.mainTabRes[a])
                       view?.tab_content_text?.setTextColor(
                           ContextCompat.getColor(
                               this@MainActivity,
                               android.R.color.darker_gray
                           )
                       )

                       view?.setBackgroundResource(R.color.color)

                   }





               }
           }

           override fun onTabUnselected(p0: TabLayout.Tab?) {
               }

           override fun onTabReselected(p0: TabLayout.Tab?) {
            }

       }
     )

     for (a in 0..4)  {
         tabLayout.addTab(tabLayout.newTab().setCustomView(getTabView(this,a)) )    }


   }


    object MainData{

        val mainFragmentList = arrayOf(home(),message(),text(),today(),purse())

        val mainTabRes= listOf(R.drawable.home,R.drawable.message,R.drawable.text,R.drawable.today,R.drawable.wallet)

        val mainTabResPressed= listOf(R.drawable.homeselected,R.drawable.messageselected,R.drawable.textselected,R.drawable.todayselected,R.drawable.walletselected)

        val mainTabStr = listOf("主頁","聊天","貼文串","Today","錢包")

        val mainmenu = listOf(R.menu.menu1,R.menu.menu2,R.menu.menu3,R.menu.menu4,R.menu.menu5)

        val mainToolbartitle = listOf("主頁","聊天","貼文串","line Today","錢包")

    }

   fun onTabItemSelected(position:Int){

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,MainData.mainFragmentList[position])!!.commit()

  }

    private fun getTabView(context: Context,position: Int):View{

        val view = LayoutInflater.from(context).inflate(R.layout.tabview,null)
        view.tab_content_image.setImageResource(MainData.mainTabRes[position])
         view.tab_content_text.text=MainData.mainTabStr[position]

        return view

    }

     override fun onCreateOptionsMenu( menu: Menu):Boolean{

        getMenuInflater().inflate(R.menu.menu2, menu)

      return true
     }


    //override fun onOptionsItemSelected(item: MenuItem): Boolean {

    //    val intent = Intent()
    //    val edit = R.id.edit
    //   when(item.itemId){
    //        R.id.edit -> {
    //           intent.setClass(this,Editmessage::class.java)
    //            this.startActivity(intent)
    //       }


    //   }
    //    return super.onOptionsItemSelected(item)
    //}



}
