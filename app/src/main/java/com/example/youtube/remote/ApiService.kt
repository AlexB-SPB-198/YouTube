package com.example.youtube.remote

import com.example.youtube.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlayList(
        @Query("part") part:String,
    @Query("channelId") channelId:String,
    @Query("key") key:String,
    ):Call<PlayList>


}

