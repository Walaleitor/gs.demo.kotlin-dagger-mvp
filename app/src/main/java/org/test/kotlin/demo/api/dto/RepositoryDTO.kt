package org.test.kotlin.demo.api.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class RepositoryDTO(
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("description") val description: String?,
        @SerializedName("html_url") val repoURL: String,
        @SerializedName("pushed_at") val pushedAt: Date
)
