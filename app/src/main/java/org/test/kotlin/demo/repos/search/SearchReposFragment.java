package org.test.kotlin.demo.repos.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import org.test.utils.LoadingAdapter;
import org.test.kotlin.demo.R;
import org.test.kotlin.demo.api.dto.RepositoryDTO;
import org.test.kotlin.demo.repos.ReposAdapter;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerFragment;

import static org.test.Utils.hideKeyboard;

public class SearchReposFragment extends DaggerFragment implements SearchReposContract.View {

    @Inject
    SearchReposContract.Presenter presenter;

    public static SearchReposFragment create() {
        return new SearchReposFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextInputLayout query = view.findViewById(R.id.query);
        EditText editText = query.getEditText();
        editText.setOnEditorActionListener((v, a, e) -> {
            performSearch();
            return true;
        });

        FloatingActionButton search = view.findViewById(R.id.search);
        search.setOnClickListener($ -> performSearch());
    }

    private void performSearch() {
        View view = getView();
        hideKeyboard(view);

        TextInputLayout query = view.findViewById(R.id.query);
        String queryValue = query.getEditText().getText().toString();
        presenter.onQueryChange(queryValue);

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setAdapter(new LoadingAdapter());
    }

    @Override
    public void showRepositories(@NonNull List<RepositoryDTO> repositories) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler);
        recyclerView.setAdapter(new ReposAdapter(repositories));
    }

}
