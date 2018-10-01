package org.test.kotlin.demo.users;

import dagger.Binds;
import dagger.Module;

@Module
public interface UsersModule {

    @Binds
    UsersContract.View bindView(UsersFragment impl);

    @Binds
    UsersContract.Presenter bindPresenter(UsersPresenter impl);

}
