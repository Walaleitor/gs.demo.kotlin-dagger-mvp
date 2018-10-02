package org.test.kotlin.demo.repos;

import org.test.kotlin.demo.api.GitHubAPI;
import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

class ReposPresenter implements ReposContract.Presenter, Comparator<RepositoryDTO> {
    private final ReposContract.View view;
    private final GitHubAPI api;
    private final String userName;
    private Single<List<RepositoryDTO>> repositories;
    private Disposable disposable = Disposables.disposed();

    @Inject
    ReposPresenter(ReposContract.View view, GitHubAPI api, @Named(ReposContract.ARG_USERNAME) String userName) {
        this.view = view;
        this.api = api;
        this.userName = userName;
    }

    @Override
    public void onViewReady() {
        loadRepositories();
    }

    private void loadRepositories() {
        if (repositories == null) {
            disposable.dispose();
            repositories = api.getUserRepositories(userName)
                    .doOnSuccess($ -> $.sort(this))
                    .cache()
                    .observeOn(AndroidSchedulers.mainThread());
        }

        disposable = repositories.subscribe(view::showRepositories);
    }

    @Override
    public int compare(RepositoryDTO a, RepositoryDTO b) {
        return -a.getPushedAt().compareTo(b.getPushedAt());
    }

}
