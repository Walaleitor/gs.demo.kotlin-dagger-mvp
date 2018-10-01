package org.test.kotlin.demo.users.repos;

import org.test.kotlin.demo.api.GitHubAPI;
import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

class RepositoriesPresenter implements RepositoriesContract.Presenter {
    private final RepositoriesContract.View view;
    private final GitHubAPI api;
    private final String userName;
    private Single<List<RepositoryDTO>> repositories;

    @Inject
    RepositoriesPresenter(RepositoriesContract.View view, GitHubAPI api, @Named(RepositoriesContract.ARG_USERNAME) String userName) {
        this.view = view;
        this.api = api;
        this.userName = userName;
    }

    @Override
    public void onViewReady() {
        retrieveUsers();
    }

    private void retrieveUsers() {
        if (repositories == null) {
            repositories = api.getUserRepositories(userName)
                    .doOnSuccess($ -> $.sort((a, b) -> -a.getPushedAt().compareTo(b.getPushedAt())))
                    .cache()
                    .observeOn(AndroidSchedulers.mainThread());
        }

        repositories.subscribe(view::showRepositories);
    }

}
