package com.example.examplenewsapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examplenewsapi.databinding.ItemSourceBinding
import com.example.examplenewsapi.model.Source

class SourceAdapter(var listSource:List<Source>):RecyclerView.Adapter<SourceAdapter.ViewHolder>() {

    var onClick : ((Source) -> Unit)? = null

    class ViewHolder (val binding:ItemSourceBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemSourceBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int  = listSource.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val source = listSource[position]
        holder.binding.nameSource.text = source.name
        holder.binding.itemSource.setOnClickListener {
            onClick?.invoke(source)
        }
    }
}