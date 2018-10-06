package org.test.kotlin.demo.users

import org.test.kotlin.demo.api.GitHubAPI
import org.test.utils.doAsync
import javax.inject.Inject

class UsersPresenter @Inject constructor(
        private val view: UsersContract.View,
        private val api: GitHubAPI) : UsersContract.Presenter {

    override fun onViewReady() {
        loadUsers()
    }

    private fun loadUsers() {
        doAsync(view::showUsers, view::showError) {
            listOf("gmazzo", "rosorio1101")
                    .map(api::getUser)
                    .map { it.execute().body()!! }
        }
    }

}
