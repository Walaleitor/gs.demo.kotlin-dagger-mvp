package org.test.kotlin.demo.users;

import org.test.kotlin.demo.api.dto.UserDTO;

import java.util.List;

interface UsersContract {

    interface View {

        void showUsers(List<UserDTO> users);

    }

    interface Presenter {

        void onViewReady();

    }

}
