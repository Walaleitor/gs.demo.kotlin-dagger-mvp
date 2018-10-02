package org.test.kotlin.demo.repos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.RepositoryDTO;
import org.test.utils.LoadingAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerFragment;

public class ReposFragment extends DaggerFragment implements ReposContract.View {

    @Inject
    ReposContract.Presenter presenter;

    public static ReposFragment create(String user) {
        Bundle args = new Bundle(1);
        args.putString(ReposContract.ARG_USERNAME, user);

        ReposFragment fragment = new ReposFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(new LoadingAdapter());
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.onViewReady();
    }

    @Override
    public void showRepositories(@NonNull List<RepositoryDTO> repositories) {
        View view = getView();

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(new ReposAdapter(repositories));
    }

}
