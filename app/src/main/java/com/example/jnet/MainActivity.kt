package com.example.jnet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.example.jnet.Adapter.AdapterUser
import com.example.jnet.ConectToNet.NetConection
import com.example.jnet.Object.userUbject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    lateinit var adapter:AdapterUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            btnreq.setOnClickListener {
                getuser()
            }

    }

    fun getuser()
    {
        var url = "https://api.myjson.com/bins/17754j"
        var params = HashMap<String,String>()
        var response = Response.Listener<String> {
            params.put("skip","0")
            params.put("take","10")

            var user = NetConection(this).dataParser(it)
            Log.i("pejman",user.toString())
            recayclel.layoutManager = LinearLayoutManager(this)
//            adapter = AdapterUser(user)
            recayclel.adapter = AdapterUser(user)

        }

        NetConection(this).apiRequst(url,params,response)
    }
}
