package com.umc.project.mbtree.dto

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id") var id: Int,
    @SerializedName("content") var content: String,
    @SerializedName("xPos") var xPos: Float,
    @SerializedName("yPos") var yPos: Float,
    @SerializedName("writerId") var writerId: User,
    @SerializedName("userId") var userId: User
)
