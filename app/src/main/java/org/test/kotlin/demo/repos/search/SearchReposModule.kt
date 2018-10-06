package org.test.kotlin.demo.repos.search

import dagger.Binds
import dagger.Module

@Module
interface SearchReposModule {

    @Binds
    fun bindView(impl: SearchReposFragment): SearchReposContract.View

    @Binds
    fun bindPresenter(impl: SearchReposPresenter): SearchReposContract.Presenter

}
