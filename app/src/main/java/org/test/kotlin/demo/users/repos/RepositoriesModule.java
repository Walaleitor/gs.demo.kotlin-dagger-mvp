package org.test.kotlin.demo.users.repos;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public interface RepositoriesModule {

    @Binds
    RepositoriesContract.View bindView(RepositoriesFragment impl);

    @Binds
    RepositoriesContract.Presenter bindPresenter(RepositoriesPresenter impl);

    @Provides
    @Named(RepositoriesContract.ARG_USERNAME)
    static String provideUserName(RepositoriesFragment fragment) {
        return fragment.getArguments().getString(RepositoriesContract.ARG_USERNAME);
    }

}
