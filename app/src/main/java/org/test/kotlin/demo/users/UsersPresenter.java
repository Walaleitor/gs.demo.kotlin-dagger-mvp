package org.test.kotlin.demo.users;

import org.test.kotlin.demo.api.GitHubAPI;
import org.test.kotlin.demo.api.dto.UserDTO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

class UsersPresenter implements UsersContract.Presenter {
    private final UsersContract.View view;
    private final GitHubAPI api;
    private Single<List<UserDTO>> users;

    @Inject
    UsersPresenter(UsersContract.View view, GitHubAPI api) {
        this.view = view;
        this.api = api;
    }

    @Override
    public void onViewReady() {
        retrieveUsers();
    }

    private void retrieveUsers() {
        if (users == null) {
            users = Observable.fromArray("gmazzo", "rosorio1101")
                    .flatMapMaybe(api::getUser)
                    .toList()
                    .cache()
                    .observeOn(AndroidSchedulers.mainThread());
        }

        users.subscribe(view::showUsers);
    }

}
