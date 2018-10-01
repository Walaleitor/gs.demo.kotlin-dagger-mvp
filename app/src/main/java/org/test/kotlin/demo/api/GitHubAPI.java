package org.test.kotlin.demo.api;

import org.test.kotlin.demo.api.dto.RepositoryDTO;
import org.test.kotlin.demo.api.dto.UserDTO;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubAPI {

    @GET("/users/{name}")
    Maybe<UserDTO> getUser(@Path("name") String name);

    @GET("/users/{name}/repos")
    Single<List<RepositoryDTO>> getUserRepositories(@Path("name") String name);

}
