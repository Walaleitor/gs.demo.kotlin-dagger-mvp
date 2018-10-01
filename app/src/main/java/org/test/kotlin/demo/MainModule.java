package org.test.kotlin.demo;

import org.test.kotlin.demo.users.UsersFragment;
import org.test.kotlin.demo.users.UsersModule;
import org.test.kotlin.demo.users.repos.RepositoriesFragment;
import org.test.kotlin.demo.users.repos.RepositoriesModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
interface MainModule {

    @ContributesAndroidInjector(modules = UsersModule.class)
    UsersFragment provideUsersFragment();

    @ContributesAndroidInjector(modules = RepositoriesModule.class)
    RepositoriesFragment provideRepositoriesFragment();

}
