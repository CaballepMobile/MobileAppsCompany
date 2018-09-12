package com.example.firebaseexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseexample.Message
import com.example.firebaseexample.R
import com.example.firebaseexample.databinding.ActivityMainBinding
import com.example.firebaseexample.databinding.MessageItemsBinding

class MessageRecycler: RecyclerView.Adapter<MessageRecycler.ViewHolder> (){
    val items:MutableList<Message>

    init {
        items = mutableListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding:MessageItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.message_items, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current_message = items[position]
        holder.binding.message.text = current_message.text
    }

    inner class ViewHolder(val binding: MessageItemsBinding):RecyclerView.ViewHolder(binding.root) {

    }
}