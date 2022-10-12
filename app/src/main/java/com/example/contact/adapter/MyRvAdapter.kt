package com.example.contact.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contact.databinding.ItemRvBinding
import com.example.contact.db.MyContact

class MyRvAdapter (var list: List<MyContact>) : RecyclerView.Adapter<MyRvAdapter.VP_Vh>() {

    inner class VP_Vh(var itemRvBinding: ItemRvBinding) :
        RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(myContact: MyContact) {
            itemRvBinding.name.text=myContact.name
            itemRvBinding.number.text=myContact.number



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size



}