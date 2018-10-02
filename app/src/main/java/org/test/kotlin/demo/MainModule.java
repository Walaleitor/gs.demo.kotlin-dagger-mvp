package org.test.kotlin.demo;

import org.test.kotlin.demo.repos.ReposFragment;
import org.test.kotlin.demo.repos.ReposModule;
import org.test.kotlin.demo.repos.search.SearchReposFragment;
import org.test.kotlin.demo.repos.search.SearchReposModule;
import org.test.kotlin.demo.users.UsersFragment;
import org.test.kotlin.demo.users.UsersModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
interface MainModule {

    @ContributesAndroidInjector(modules = UsersModule.class)
    UsersFragment provideUsersFragment();

    @ContributesAndroidInjector(modules = ReposModule.class)
    ReposFragment provideReposFragment();

    @ContributesAndroidInjector(modules = SearchReposModule.class)
    SearchReposFragment provideSearchReposFragment();

}
