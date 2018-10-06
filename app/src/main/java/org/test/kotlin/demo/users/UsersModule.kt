package org.test.kotlin.demo.users

import dagger.Binds
import dagger.Module

@Module
interface UsersModule {

    @Binds
    fun bindView(impl: UsersFragment): UsersContract.View

    @Binds
    fun bindPresenter(impl: UsersPresenter): UsersContract.Presenter

}
