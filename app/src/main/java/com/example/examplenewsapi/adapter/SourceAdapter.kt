package com.example.examplenewsapi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examplenewsapi.databinding.ItemSourceBinding
import com.example.examplenewsapi.model.Source

class SourceAdapter(var listSource : List<Source>) : RecyclerView.Adapter<SourceAdapter.ViewHolder> () {
    var onClick : ((Source)->Unit)? = null

    class ViewHolder(var binding: ItemSourceBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceAdapter.ViewHolder {
        val view = ItemSourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SourceAdapter.ViewHolder, position: Int) {
        holder.binding.nameSource.text = listSource[position].name
    }

    override fun getItemCount(): Int {
        return listSource.size
    }

    fun listSource(list: List<Source>){
        this.listSource = list
        notifyDataSetChanged()

        Log.d("HASIL_SOURCE", list.toString())
    }
}