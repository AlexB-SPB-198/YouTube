package com.example.youtube.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.youtube.BuildConfig
import com.example.youtube.model.PlayList
import com.example.youtube.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    private val apiService = RetrofitClient.create()


    fun getPlayList(): LiveData<PlayList> {
        return createCall()
    }

    private fun createCall():LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()
        apiService.getPlayList(
            "snippet,contentDetails",
            "UCDF_NIAEkcAUvzxe1DUzaQA",BuildConfig.API_KEY
        ).enqueue(object : Callback<PlayList> {
            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                if (response.isSuccessful){
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
                print(t.stackTrace)
            }
        })
        return data
    }


}