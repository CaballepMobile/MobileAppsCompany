package com.example.admin.codechallengekotlin.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.admin.codechallengekotlin.R
import com.example.admin.codechallengekotlin.data.remote.models.MetaWeatherResponse
import com.example.admin.codechallengekotlin.databinding.RecyclerViewItemBinding

class WeatherAdapter(private val weatherList: List<MetaWeatherResponse>, private val context: Context) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapter.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val itemBinding = DataBindingUtil
                .inflate<RecyclerViewItemBinding>(LayoutInflater.from(parent.context),
                        R.layout.recycler_view_item, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return weatherList.size
    }

    override fun onBindViewHolder(holder: WeatherAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var temp = weatherList[position]
        holder.binding.textView.text = temp.weatherStateName
        holder.binding.textView3.text = temp.created
        Glide.with(context).load("https://www.metaweather.com/static/img/weather/png/64/${temp.weatherStateAbbr}.png").into(holder.binding.imageView)
    }

    class ViewHolder(var binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root)

}