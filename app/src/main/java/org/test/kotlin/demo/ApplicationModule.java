package org.test.kotlin.demo;

import android.content.Context;

import org.test.kotlin.demo.api.GitHubModule;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = GitHubModule.class)
interface ApplicationModule {

    @Binds
    Context bindContext(Application application);

    @ContributesAndroidInjector(modules = MainModule.class)
    MainActivity provideMainActivity();

    @Provides
    static Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .validateEagerly(true)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .baseUrl("http://server/somePath/");
    }

}
