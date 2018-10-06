package org.test.kotlin.demo.repos

import org.test.kotlin.demo.api.dto.RepositoryDTO

interface ReposContract {

    interface View {

        fun showRepositories(repositories: List<RepositoryDTO>)

        fun showError(throwable: Throwable)

    }

    interface Presenter {

        fun onViewReady()

    }

    companion object {

        const val ARG_USERNAME = "userName"

    }

}
