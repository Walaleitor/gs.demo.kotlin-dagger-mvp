package org.test.kotlin.demo.users;

import org.test.kotlin.demo.api.GitHubAPI;
import org.test.kotlin.demo.api.dto.UserDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

class UsersPresenter implements UsersContract.Presenter {
    private final UsersContract.View view;
    private final GitHubAPI api;
    private Single<List<UserDTO>> users;
    private Disposable disposable = Disposables.disposed();

    @Inject
    UsersPresenter(UsersContract.View view, GitHubAPI api) {
        this.view = view;
        this.api = api;
    }

    @Override
    public void onViewReady() {
        loadUsers();
    }

    private void loadUsers() {
        if (users == null) {
            disposable.dispose();
            users = Observable.fromArray("gmazzo", "rosorio1101")
                    .flatMapMaybe(api::getUser)
                    .toList()
                    .cache()
                    .observeOn(AndroidSchedulers.mainThread());
        }

        disposable = users.subscribe(view::showUsers);
    }

}
