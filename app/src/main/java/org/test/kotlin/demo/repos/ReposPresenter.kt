package org.test.kotlin.demo.repos

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import org.test.kotlin.demo.api.GitHubAPI
import org.test.kotlin.demo.api.dto.RepositoryDTO
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class ReposPresenter @Inject constructor(
        @Named(ReposContract.ARG_USERNAME) private val userName: String,
        private val view: ReposContract.View,
        private val api: GitHubAPI) : ReposContract.Presenter, Comparator<RepositoryDTO> {

    private var repositories: Single<List<RepositoryDTO>>? = null
    private var disposable = Disposables.disposed()

    override fun onViewReady() {
        loadRepositories()
    }

    private fun loadRepositories() {
        if (repositories == null) {
            disposable.dispose()
            repositories = api.getUserRepositories(userName)
                    .doOnSuccess { Collections.sort(it, this) }
                    .cache()
                    .observeOn(AndroidSchedulers.mainThread())
        }

        disposable = repositories!!.subscribe(view::showRepositories)
    }

    override fun compare(a: RepositoryDTO, b: RepositoryDTO): Int {
        return -a.pushedAt.compareTo(b.pushedAt)
    }

}
