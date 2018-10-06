package org.test.kotlin.demo.repos.search

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import org.test.kotlin.demo.api.GitHubAPI
import org.test.kotlin.demo.api.dto.RepositoryDTO
import org.test.kotlin.demo.api.dto.SearchDTO
import javax.inject.Inject

class SearchReposPresenter @Inject constructor(
        private val view: SearchReposContract.View,
        private val api: GitHubAPI) : SearchReposContract.Presenter {

    private var disposable = Disposables.disposed()

    override fun onQueryChange(query: String) {
        disposable.dispose()
        disposable = api.searchRepositories(query)
                .map(SearchDTO<RepositoryDTO>::items)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showRepositories, view::showError)
    }

}
