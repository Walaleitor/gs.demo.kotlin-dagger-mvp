package org.test.kotlin.demo.api

import org.test.kotlin.demo.api.dto.RepositoryDTO
import org.test.kotlin.demo.api.dto.SearchDTO
import org.test.kotlin.demo.api.dto.UserDTO

import io.reactivex.Maybe
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubAPI {

    @GET("users/{name}")
    fun getUser(@Path("name") name: String): Maybe<UserDTO>

    @GET("users/{name}/repos")
    fun getUserRepositories(@Path("name") name: String): Single<List<RepositoryDTO>>

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String): Single<SearchDTO<RepositoryDTO>>

}
