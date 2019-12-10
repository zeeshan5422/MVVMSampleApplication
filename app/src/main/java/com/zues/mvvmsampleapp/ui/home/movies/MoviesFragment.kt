package com.zues.mvvmsampleapp.ui.home.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.zues.mvvmsampleapp.R
import com.zues.mvvmsampleapp.data.models.Movie
import com.zues.mvvmsampleapp.utils.hide
import com.zues.mvvmsampleapp.utils.show
import com.zues.mvvmsampleapp.utils.toast
import kotlinx.android.synthetic.main.movies_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class MoviesFragment : Fragment(), KodeinAware, RecyclerViewClickListener {

    override val kodein by kodein()

    private val factory: MoviesViewModelFactory by instance()

    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)
        viewModel.getMovies()
        progress_bar.show()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                progress_bar.hide()
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
//                context?.toast(movies.toString())
                it.adapter = MoviesAdapter(movies, this)
            }

        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: Movie) {
        when (view.id) {
            R.id.button_book -> {
                context?.toast("Book Button Clicked")
            }
            R.id.layout_like -> {
                context?.toast("Like Layout Clicked")
            }
        }
    }

}
