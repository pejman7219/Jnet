package com.example.jnet.ConectToNet

import android.content.Context
import android.util.Log
import android.widget.TextView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jnet.Object.userUbject
import org.json.JSONException
import org.json.JSONObject

class NetConection(internal var context: Context) {



    fun apiRequst(url : String,params: HashMap<String,String>,response:Response.Listener<String>)
    {
        var strRequst = object : StringRequest(Request.Method.POST,url,response,Response.ErrorListener {

        }) {
            override fun getParams(): Map<String, String> {
//                params.put("skip", "0")
//                params.put("take", "10")
                return params
            }

        }
        try {
            val que = Volley.newRequestQueue(context)
            strRequst.retryPolicy = DefaultRetryPolicy(
                10000,
                3,

                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
            que.add(strRequst)


        }catch (e : JSONException)
        {

        }
    }
    fun dataParser(response: String): ArrayList<userUbject>
    {
        var result = ArrayList<userUbject>()
        val jsdata = JSONObject(response)
        val status = jsdata.optString("ststus")
        val mesage = jsdata.optString("message")
        val jslink = jsdata.getJSONArray("data")
        Log.i("pejman",jslink.toString())
        if (status == "ok")
        {
            for (i in 0 until jslink.length())
            {
//                    var item = userUbject()
                var etelaat = userUbject().dataParser(jslink.getJSONObject(i))
//                    item.id = etelaat.optInt("id")
//                    item.name = etelaat.optString("name")
//                    item.email = etelaat.optString("email")
//                    item.address = etelaat.optString("address")

                result.add(etelaat)
                Log.i("pejman",etelaat.toString())

            }
        }

        return result
    }









}