package org.test.kotlin.demo.users

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposables
import org.test.kotlin.demo.api.GitHubAPI
import org.test.kotlin.demo.api.dto.UserDTO
import javax.inject.Inject

class UsersPresenter @Inject constructor(
        private val view: UsersContract.View,
        private val api: GitHubAPI) : UsersContract.Presenter {

    private var users: Single<List<UserDTO>>? = null
    private var disposable = Disposables.disposed()

    override fun onViewReady() {
        loadUsers()
    }

    private fun loadUsers() {
        if (users == null) {
            disposable.dispose()
            users = Observable.fromArray("gmazzo", "rosorio1101")
                    .flatMapMaybe(api::getUser)
                    .toList()
                    .cache()
                    .observeOn(AndroidSchedulers.mainThread())
        }

        disposable = users!!.subscribe(view::showUsers)
    }

}
