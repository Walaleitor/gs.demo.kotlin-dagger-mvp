package org.test.kotlin.demo.users

import org.test.kotlin.demo.api.dto.UserDTO

interface UsersContract {

    interface View {

        fun showUsers(users: List<UserDTO>)

    }

    interface Presenter {

        fun onViewReady()

    }

}
