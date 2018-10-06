package org.test.kotlin.demo.repos.search

import org.test.kotlin.demo.api.GitHubAPI
import org.test.kotlin.demo.api.dto.RepositoryDTO
import org.test.kotlin.demo.api.dto.SearchDTO
import org.test.utils.doAsync
import javax.inject.Inject

class SearchReposPresenter @Inject constructor(
        private val view: SearchReposContract.View,
        private val api: GitHubAPI) : SearchReposContract.Presenter {

    override fun onQueryChange(query: String) {
        doAsync(view::showRepositories, view::showError) {
            api.searchRepositories(query)
                    .execute()
                    .body()!!
                    .let(SearchDTO<RepositoryDTO>::items)
        }
    }

}
