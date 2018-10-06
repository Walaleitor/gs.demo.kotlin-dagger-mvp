package org.test.kotlin.demo.repos

import org.test.kotlin.demo.api.GitHubAPI
import org.test.utils.doAsync
import javax.inject.Inject
import javax.inject.Named

class ReposPresenter @Inject constructor(
        @Named(ReposContract.ARG_USERNAME) private val userName: String,
        private val view: ReposContract.View,
        private val api: GitHubAPI) : ReposContract.Presenter {

    override fun onViewReady() {
        loadRepositories()
    }

    private fun loadRepositories() {
        doAsync(view::showRepositories, view::showError) {
            api.getUserRepositories(userName)
                    .execute()
                    .body()!!
                    .sortedBy { -it.pushedAt.time }
        }
    }

}
