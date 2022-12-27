package br.com.igorbag.githubsearch.domain

import com.google.gson.annotations.SerializedName

data class Repository(
    val name: String,
    @SerializedName("html_url")
    val htmlUrl: String,
    val language:String,
    @SerializedName("stargazers_count")
    val starsCount:Int,
    @SerializedName("created_at")
    val creationDate:String

)