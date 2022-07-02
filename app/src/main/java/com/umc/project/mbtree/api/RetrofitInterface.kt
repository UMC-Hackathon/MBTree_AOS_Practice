package com.umc.project.mbtree.api

import com.umc.project.mbtree.dto.Post
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {
    @POST("/posts")
    fun createPost(post: Post)

    @GET("/tree")
    fun getPosts(@Query("useridx")useridx: Int?): Call<List<Post>>

}