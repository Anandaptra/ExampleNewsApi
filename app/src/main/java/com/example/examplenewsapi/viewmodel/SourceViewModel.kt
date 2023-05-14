package com.example.examplenewsapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplenewsapi.model.ResponseDataSource
import com.example.examplenewsapi.model.Source
import com.example.examplenewsapi.network.ApiService
import com.example.examplenewsapi.network.NetworkClient
import dagger.hilt.android.lifecycle.HiltViewModel
import hilt_aggregated_deps._com_example_examplenewsapi_network_NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SourceViewModel @Inject constructor(var api : ApiService): ViewModel() {
    lateinit var liveDataSource : MutableLiveData<List<Source>?>

    init {
        liveDataSource = MutableLiveData()
    }

    fun getDataSource():MutableLiveData<List<Source>?> {
        return liveDataSource
    }

    fun callApiSource(category: String){
        api.getAllSources(category).enqueue(object : Callback<ResponseDataSource>{
            override fun onResponse(
                call: Call<ResponseDataSource>,
                response: Response<ResponseDataSource>
            ) {
                if (response.isSuccessful){
                    liveDataSource.postValue(response.body()!!.sources)

                }else{
                    liveDataSource.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDataSource>, t: Throwable) {
                liveDataSource.postValue(null)
            }

        })
    }

}