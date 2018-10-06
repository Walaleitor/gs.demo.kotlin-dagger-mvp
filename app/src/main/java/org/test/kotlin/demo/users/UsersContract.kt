package org.test.kotlin.demo.users

import org.test.kotlin.demo.api.dto.UserDTO

interface UsersContract {

    interface View {

        fun showUsers(users: List<UserDTO>)

        fun showError(throwable: Throwable)

    }

    interface Presenter {

        fun onViewReady()

    }

}
