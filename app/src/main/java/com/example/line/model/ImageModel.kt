package com.example.line.model

data class ImageModel (
    val title: String
   ,val text: String
  ,val time: String
  ,val pp: String
  , val image:Int
 , var isSelected: Boolean = false
)

var itemList=mutableListOf<ImageModel>()