package org.test.kotlin.demo.repos.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_recycler.recycler
import kotlinx.android.synthetic.main.fragment_search.*
import org.test.kotlin.demo.R
import org.test.kotlin.demo.api.dto.RepositoryDTO
import org.test.kotlin.demo.repos.ReposAdapter
import org.test.utils.LoadingAdapter
import org.test.utils.hideKeyboard
import org.test.utils.inflate
import org.test.utils.log
import javax.inject.Inject

class SearchReposFragment : DaggerFragment(), SearchReposContract.View {

    @Inject
    internal lateinit var presenter: SearchReposContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            container!!.inflate(R.layout.fragment_search)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        query.editText!!.setOnEditorActionListener { _, _, _ ->
            performSearch()
            true
        }

        search.setOnClickListener { performSearch() }
    }

    private fun performSearch() {
        view!!.hideKeyboard()

        query.isErrorEnabled = false
        val queryValue = query.editText!!.text.toString()
        presenter.onQueryChange(queryValue)

        recycler.adapter = LoadingAdapter()
    }

    override fun showRepositories(repositories: List<RepositoryDTO>) {
        recycler.adapter = ReposAdapter(repositories)
    }

    override fun showError(throwable: Throwable) {
        throwable.log()

        query.error = throwable.localizedMessage

        recycler.adapter = null
    }

    companion object {

        fun create() = SearchReposFragment()

    }

}
