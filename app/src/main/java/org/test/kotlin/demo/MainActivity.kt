package org.test.kotlin.demo

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.test.kotlin.demo.repos.search.SearchReposFragment
import org.test.kotlin.demo.users.UsersFragment
import org.test.utils.toast

class MainActivity : DaggerAppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected)

        supportFragmentManager.addOnBackStackChangedListener(this)

        if (savedInstanceState == null) {
            onNavigationItemSelected(navigation.menu.findItem(R.id.users))
        }
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.title.toast(this)

        when (item.itemId) {
            R.id.users -> UsersFragment.create()
            R.id.search -> SearchReposFragment.create()
            else -> null

        }?.let { fragment ->
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContent, fragment)
                    .commit()
        }
        return true
    }

    override fun onBackStackChanged() {
        val canGoBack = supportFragmentManager.backStackEntryCount > 0

        supportActionBar!!.setDisplayHomeAsUpEnabled(canGoBack)
    }

}
