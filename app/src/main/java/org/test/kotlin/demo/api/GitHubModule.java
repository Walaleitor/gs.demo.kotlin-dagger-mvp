package org.test.kotlin.demo.api;

import javax.inject.Provider;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public interface GitHubModule {

    @Provides
    @Singleton
    static GitHubAPI provideAPI(Provider<Retrofit.Builder> retrofit) {
        return retrofit.get()
                .baseUrl("https://api.github.com/")
                .build()
                .create(GitHubAPI.class);
    }

}
