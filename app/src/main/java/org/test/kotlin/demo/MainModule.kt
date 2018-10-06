package org.test.kotlin.demo

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.test.kotlin.demo.repos.ReposFragment
import org.test.kotlin.demo.repos.ReposModule
import org.test.kotlin.demo.repos.search.SearchReposFragment
import org.test.kotlin.demo.repos.search.SearchReposModule
import org.test.kotlin.demo.users.UsersFragment
import org.test.kotlin.demo.users.UsersModule

@Module
internal interface MainModule {

    @ContributesAndroidInjector(modules = [UsersModule::class])
    fun provideUsersFragment(): UsersFragment

    @ContributesAndroidInjector(modules = [ReposModule::class])
    fun provideReposFragment(): ReposFragment

    @ContributesAndroidInjector(modules = [SearchReposModule::class])
    fun provideSearchReposFragment(): SearchReposFragment

}
