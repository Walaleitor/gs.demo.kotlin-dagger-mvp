package org.test.kotlin.demo.repos

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class ReposModule {

    @Binds
    abstract fun bindView(impl: ReposFragment): ReposContract.View

    @Binds
    abstract fun bindPresenter(impl: ReposPresenter): ReposContract.Presenter

    @Module
    companion object {

        @Provides
        @JvmStatic
        @Named(ReposContract.ARG_USERNAME)
        fun provideUserName(fragment: ReposFragment) =
                fragment.arguments!!.getString(ReposContract.ARG_USERNAME)!!

    }

}
