package org.test.kotlin.demo.api;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public interface GitHubModule {

    @Provides
    static GitHubAPI provideAPI(Retrofit.Builder retrofit) {
        return retrofit
                .baseUrl("https://api.github.com")
                .build()
                .create(GitHubAPI.class);
    }

}
