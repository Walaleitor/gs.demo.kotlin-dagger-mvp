package org.test.kotlin.demo.users;

import org.test.kotlin.demo.api.dto.UserDTO;

import java.util.List;

import androidx.annotation.NonNull;

interface UsersContract {

    interface View {

        void showUsers(@NonNull List<UserDTO> users);

    }

    interface Presenter {

        void onViewReady();

    }

}
