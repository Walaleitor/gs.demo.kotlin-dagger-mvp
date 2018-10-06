package org.test.kotlin.demo.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Provider
import javax.inject.Singleton

@Module
abstract class GitHubModule {

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideAPI(retrofit: Provider<Retrofit.Builder>) = retrofit
                .get()
                .baseUrl("https://api.github.com/")
                .build()
                .create(GitHubAPI::class.java)!!

    }

}
