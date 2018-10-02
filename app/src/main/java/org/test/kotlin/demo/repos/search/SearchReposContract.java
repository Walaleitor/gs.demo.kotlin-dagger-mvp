package org.test.kotlin.demo.repos.search;

import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.List;

import androidx.annotation.NonNull;

interface SearchReposContract {

    interface View {

        void showRepositories(@NonNull List<RepositoryDTO> repositories);

        void showError(Throwable throwable);

    }

    interface Presenter {

        void onQueryChange(@NonNull String query);

    }

}
