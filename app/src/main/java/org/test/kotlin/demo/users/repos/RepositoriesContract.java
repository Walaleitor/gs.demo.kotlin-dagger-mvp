package org.test.kotlin.demo.users.repos;

import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.List;

interface RepositoriesContract {

    String ARG_USERNAME = "userName";

    interface View {

        void showRepositories(List<RepositoryDTO> repositories);

    }

    interface Presenter {

        void onViewReady();

    }

}
