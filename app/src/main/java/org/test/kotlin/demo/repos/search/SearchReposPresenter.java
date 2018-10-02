package org.test.kotlin.demo.repos.search;

import org.test.kotlin.demo.api.GitHubAPI;
import org.test.kotlin.demo.api.dto.SearchDTO;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;

class SearchReposPresenter implements SearchReposContract.Presenter {
    private final SearchReposContract.View view;
    private final GitHubAPI api;
    private Disposable disposable = Disposables.disposed();

    @Inject
    SearchReposPresenter(SearchReposContract.View view, GitHubAPI api) {
        this.view = view;
        this.api = api;
    }

    @Override
    public void onQueryChange(@NonNull String query) {
        disposable.dispose();
        disposable = api.searchRepositories(query)
                .map(SearchDTO::getItems)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showRepositories);
    }

}
