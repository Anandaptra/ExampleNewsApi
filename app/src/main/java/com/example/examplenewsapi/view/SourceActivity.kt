package com.example.examplenewsapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examplenewsapi.R
import com.example.examplenewsapi.adapter.SourceAdapter
import com.example.examplenewsapi.databinding.ActivitySourceBinding
import com.example.examplenewsapi.viewmodel.SourceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySourceBinding
    private lateinit var sourceAdapter: SourceAdapter
    lateinit var viewModel : SourceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SourceViewModel::class.java)


        val bundle = intent.extras
        val catName = bundle?.getString("category")

        viewModel.callApiSource(catName!!)
        viewModel.liveDataSource.observe(this){
            it?.map {
                Log.d("SourceActivity", it.name)
            }
            sourceAdapter = SourceAdapter(it!!)
            binding.rvSource.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = sourceAdapter
            }
            sourceAdapter.onClick = {   source ->
                val intent = Intent(this@SourceActivity,ArticleActivity::class.java)
                val sourceItem = source.id
                val bundle = Bundle()
                bundle.putString("source",sourceItem)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}