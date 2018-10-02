package org.test.kotlin.demo.repos;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface ReposModule {

    @Binds
    ReposContract.View bindView(ReposFragment impl);

    @Binds
    ReposContract.Presenter bindPresenter(ReposPresenter impl);

    @Provides
    @Named(ReposContract.ARG_USERNAME)
    static String provideUserName(ReposFragment fragment) {
        return fragment.getArguments().getString(ReposContract.ARG_USERNAME);
    }

}
