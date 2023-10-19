package com.sheoran.kotlinapi

class DemoDataModel : ArrayList<DemoDataModelItem>()

data class DemoDataModelItem(
    val comleted:Boolean,
    val id: Int,
    val title:String,
    val userId:Int


)