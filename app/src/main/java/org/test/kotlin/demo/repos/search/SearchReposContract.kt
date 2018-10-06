package org.test.kotlin.demo.repos.search

import org.test.kotlin.demo.api.dto.RepositoryDTO

interface SearchReposContract {

    interface View {

        fun showRepositories(repositories: List<RepositoryDTO>)

        fun showError(throwable: Throwable)

    }

    interface Presenter {

        fun onQueryChange(query: String)

    }

}
