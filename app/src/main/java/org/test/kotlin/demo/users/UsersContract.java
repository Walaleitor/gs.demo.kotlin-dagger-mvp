package org.test.kotlin.demo.users;

import org.test.kotlin.demo.model.User;

import java.util.List;

interface UsersContract {

    interface View {

        void showUsers(List<User> users);

    }

    interface Presenter {

        void onViewReady();

    }

}
