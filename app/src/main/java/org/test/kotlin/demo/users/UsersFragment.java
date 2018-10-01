package org.test.kotlin.demo.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import org.test.LoadingAdapter;
import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.UserDTO;

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

    {
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_users, container, false);
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
    public void showUsers(List<UserDTO> users) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler);
        recyclerView.setAdapter(new UsersAdapter(users, this::onUserSelected));
    }

    private void onUserSelected(UserDTO user) {
        getFragmentManager().beginTransaction() // TODO podría hacerse genérico
                // FIXME .replace(getId(), UsersEditFragment.create(user))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.fragment_users, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                getFragmentManager().beginTransaction() // TODO podría hacerse genérico
                        // FIXME .replace(getId(), UsersEditFragment.create())
                        .addToBackStack(null)
                        .commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
