package com.example.jnet.Object

import org.json.JSONObject

class userUbject {

    var id : Int? = null
    var name : String? = null
    var email : String? = null
    var address : String? = null

    fun dataParser(jsondata : JSONObject):userUbject
    {

        id = jsondata.optInt("id")
        name = jsondata.optString("name")
        email = jsondata.optString("email")
        address = jsondata.optString("address")

        return this
    }

}