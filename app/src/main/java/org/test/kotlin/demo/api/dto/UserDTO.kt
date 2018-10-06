package org.test.kotlin.demo.api.dto

import com.google.gson.annotations.SerializedName

data class UserDTO(
        @SerializedName("id") val id: Long,
        @SerializedName("login") val user: String,
        @SerializedName("name") val name: String,
        @SerializedName("avatar_url") val avatarURL: String,
        @SerializedName("html_url") val profileURL: String,
        @SerializedName("public_repos") val repositories: Int
)
