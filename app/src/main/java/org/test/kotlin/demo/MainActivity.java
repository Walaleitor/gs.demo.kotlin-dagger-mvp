package org.test.kotlin.demo;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.test.kotlin.demo.repos.search.SearchReposFragment;
import org.test.kotlin.demo.users.UsersFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        getSupportFragmentManager().addOnBackStackChangedListener(this);

        if (savedInstanceState == null) {
            onNavigationItemSelected(navigation.getMenu().findItem(R.id.users));
        }
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show(); // TODO código duplicado

        Fragment newFragment = null;
        switch (item.getItemId()) {
            case R.id.users:
                newFragment = UsersFragment.create();
                break;

            case R.id.search:
                newFragment = SearchReposFragment.create();
                break;
        }

        if (newFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContent, newFragment)
                    .commit();
        }
        return true;
    }

    @Override
    public void onBackStackChanged() {
        boolean canGoBack = getSupportFragmentManager().getBackStackEntryCount() > 0;

        getSupportActionBar().setDisplayHomeAsUpEnabled(canGoBack);
    }

}
