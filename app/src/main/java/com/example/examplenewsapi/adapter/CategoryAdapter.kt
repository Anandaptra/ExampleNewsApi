package com.example.examplenewsapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.examplenewsapi.databinding.ItemCategoryBinding
import com.example.examplenewsapi.model.CategoryData

class CategoryAdapter(var listCategory: List<CategoryData>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var onClick : ((CategoryData) -> Unit)? = null

    class ViewHolder(var binding : ItemCategoryBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.CategoryName.text = listCategory[position].name
        Glide.with(holder.itemView).load(listCategory[position].picture).into(holder.binding.imgCategory)
        holder.binding.itemCategory.setOnClickListener {
            this.onClick!!.invoke(listCategory[position])
        }
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }

}