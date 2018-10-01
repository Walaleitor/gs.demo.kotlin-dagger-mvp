package org.test.kotlin.demo;

import org.test.kotlin.demo.users.UsersFragment;
import org.test.kotlin.demo.users.UsersModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
interface MainModule {

    @ContributesAndroidInjector(modules = UsersModule.class)
    UsersFragment provideUsersFragment();

}
