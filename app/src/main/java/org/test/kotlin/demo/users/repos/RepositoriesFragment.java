package org.test.kotlin.demo.users.repos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.test.LoadingAdapter;
import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.RepositoryDTO;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerFragment;

public class RepositoriesFragment extends DaggerFragment implements RepositoriesContract.View {

    @Inject
    RepositoriesContract.Presenter presenter;

    public static RepositoriesFragment create(String user) {
        Bundle args = new Bundle(1);
        args.putString(RepositoriesContract.ARG_USERNAME, user);

        RepositoriesFragment fragment = new RepositoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    {
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = getView().findViewById(R.id.recycler);
        recyclerView.setAdapter(new LoadingAdapter());
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.onViewReady();
    }

    @Override
    public void showRepositories(List<RepositoryDTO> repositories) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler);
        recyclerView.setAdapter(new RepositoriesAdapter(repositories));
    }

}
