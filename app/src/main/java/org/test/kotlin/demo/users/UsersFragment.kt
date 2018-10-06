package org.test.kotlin.demo.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.test.kotlin.demo.R
import org.test.kotlin.demo.api.dto.UserDTO
import org.test.kotlin.demo.repos.ReposFragment
import org.test.utils.LoadingAdapter
import org.test.utils.inflate
import org.test.utils.replaceWith
import javax.inject.Inject

class UsersFragment : DaggerFragment(), UsersContract.View {

    @Inject
    internal lateinit var presenter: UsersContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            container!!.inflate(R.layout.fragment_recycler)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.adapter = LoadingAdapter()
    }

    override fun onStart() {
        super.onStart()

        presenter.onViewReady()
    }

    override fun showUsers(users: List<UserDTO>) {
        recycler.adapter = UsersAdapter(users, this::onUserSelected)
    }

    private fun onUserSelected(user: UserDTO) {
        replaceWith(ReposFragment.create(user.user), addToBackStack = true)
    }

    companion object {

        fun create() = UsersFragment()

    }

}
