package org.test.kotlin.demo.api.dto

import com.google.gson.annotations.SerializedName

data class SearchDTO<T>(
        @SerializedName("items") val items: List<T>,
        @SerializedName("total_count") val totalCount: Int,
        @SerializedName("incomplete_results") val isIncompleteResults: Boolean
)
