package com.example.examplenewsapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examplenewsapi.R
import com.example.examplenewsapi.adapter.CategoryAdapter
import com.example.examplenewsapi.databinding.ActivityCategoryBinding
import com.example.examplenewsapi.model.CategoryData

class CategoryActivity : AppCompatActivity() {
    lateinit var binding : ActivityCategoryBinding
    lateinit var categoryAdapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listCategory = arrayListOf(
            CategoryData("BUSINESS", R.drawable.img_1),
            CategoryData("ENTERTAINMENT", R.drawable.img_1),
            CategoryData("GENERAL", R.drawable.img_1),
            CategoryData("HEALTH", R.drawable.img_1),
            CategoryData("SCIENCE", R.drawable.img_1),
            CategoryData("SPORTS", R.drawable.img_1),
            CategoryData("TECHNOLOGY", R.drawable.img_1)
        )
        categoryAdapter = CategoryAdapter(listCategory)
        binding.rvCategory.apply {
            layoutManager =
                LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL, false)
            adapter = categoryAdapter
            categoryAdapter.onClick = {
                var categ = it.name
                val inten = Intent(context, SourceActivity::class.java)
                inten.putExtra("name", categ)
                startActivity(inten)
            }
        }
    }



}