package org.test.kotlin.demo;

import android.content.Context;

import org.test.kotlin.demo.api.GitHubModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = GitHubModule.class)
interface ApplicationModule {

    @Binds
    Context bindContext(Application application);

    @ContributesAndroidInjector(modules = MainModule.class)
    MainActivity provideMainActivity();

}
