package org.test.kotlin.demo.repos;

import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.List;

import androidx.annotation.NonNull;

interface ReposContract {

    String ARG_USERNAME = "userName";

    interface View {

        void showRepositories(@NonNull List<RepositoryDTO> repositories);

    }

    interface Presenter {

        void onViewReady();

    }

}
