package org.test.kotlin.demo.api;

import org.test.kotlin.demo.api.dto.RepositoryDTO;
import org.test.kotlin.demo.api.dto.UserDTO;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubAPI {

    @GET("/users/{name}")
    UserDTO getUser(@Path("name") String name);

    @GET("/users/{name}/repos")
    List<RepositoryDTO> getUserRepositories(@Path("name") String name);

}
