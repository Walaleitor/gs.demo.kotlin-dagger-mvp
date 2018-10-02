package org.test.kotlin.demo.repos.search;

import dagger.Binds;
import dagger.Module;

@Module
public interface SearchReposModule {

    @Binds
    SearchReposContract.View bindView(SearchReposFragment impl);

    @Binds
    SearchReposContract.Presenter bindPresenter(SearchReposPresenter impl);

}
