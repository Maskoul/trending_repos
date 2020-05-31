package com.example.trendingrepos.ui.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.trendingrepos.database.RepositoryRoomDatabase
import com.example.trendingrepos.databinding.FragmentOverviewReposBinding
import com.example.trendingrepos.repository.TrendingRepoRepository


class OverviewReposFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewReposBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this


        val context = requireNotNull(activity).applicationContext
        val roomDatabase = RepositoryRoomDatabase.getInstance(context)
        val trendingRepoRepository = TrendingRepoRepository(roomDatabase)

        val factory = OverviewViewModelFactory(trendingRepoRepository)
        val viewModel = ViewModelProvider(
            this,
            factory
        ).get(OverviewViewModel::class.java)

        val adapter = RepositoryAdapter(RepositoryAdapter.OnClickListener {
            viewModel.onNavigateToDetail(it)
        })
        binding.repoRecyclerList.adapter = adapter

        viewModel.naveToDetailEvent.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController().navigate(
                    OverviewReposFragmentDirections.actionOverviewReposFragmentToDetailFragment(it)
                )
                viewModel.doneNavigateToDetail()
            }
        })


        binding.viewModel = viewModel


        return (binding.root)
    }


}
