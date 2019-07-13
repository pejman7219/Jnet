package com.example.jnet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jnet.Object.userUbject
import com.example.jnet.R

class AdapterUser(var user:ArrayList<userUbject>) : RecyclerView.Adapter<AdapterUser.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.simpel_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = user[position].id.toString()
        holder.name.text = user[position].name
        holder.email.text = user[position].email
        holder.address.text = user[position].address
    }

    class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView)
    {
        var id = itemView.findViewById<TextView>(R.id.textid)
        var name = itemView.findViewById<TextView>(R.id.textname)
        var email = itemView.findViewById<TextView>(R.id.textemail)
        var address = itemView.findViewById<TextView>(R.id.textaddress)
    }
}