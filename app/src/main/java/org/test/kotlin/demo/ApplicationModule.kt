package org.test.kotlin.demo

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import org.test.kotlin.demo.api.GitHubModule
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [GitHubModule::class])
abstract class ApplicationModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun provideMainActivity(): MainActivity

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideRetrofit() = Retrofit.Builder()
                .validateEagerly(true)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .baseUrl("http://server/somePath/")!!

    }

}
