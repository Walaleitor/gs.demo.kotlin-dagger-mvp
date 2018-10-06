package org.test.kotlin.demo.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_recycler.*
import org.test.kotlin.demo.R
import org.test.kotlin.demo.api.dto.RepositoryDTO
import org.test.utils.LoadingAdapter
import org.test.utils.inflate
import javax.inject.Inject

class ReposFragment : DaggerFragment(), ReposContract.View {

    @Inject
    internal lateinit var presenter: ReposContract.Presenter

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

    override fun showRepositories(repositories: List<RepositoryDTO>) {
        recycler.adapter = ReposAdapter(repositories)
    }

    companion object {

        fun create(user: String) = ReposFragment().apply {
            arguments = bundleOf(ReposContract.ARG_USERNAME to user)
        }

    }

}
