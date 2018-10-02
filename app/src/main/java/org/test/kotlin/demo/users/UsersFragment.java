package org.test.kotlin.demo.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.UserDTO;
import org.test.kotlin.demo.repos.ReposFragment;
import org.test.utils.LoadingAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerFragment;

public class UsersFragment extends DaggerFragment implements UsersContract.View {

    @Inject
    UsersContract.Presenter presenter;

    public static UsersFragment create() {
        return new UsersFragment();
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
    public void showUsers(@NonNull List<UserDTO> users) {
        View view = getView();

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(new UsersAdapter(users, this::onUserSelected));
    }

    private void onUserSelected(UserDTO user) {
        getFragmentManager().beginTransaction() // TODO podría hacerse genérico
                .replace(getId(), ReposFragment.create(user.getUser()))
                .addToBackStack(null)
                .commit();
    }

}
