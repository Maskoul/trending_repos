package com.example.trendingrepos.ui.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trendingrepos.R

import com.example.trendingrepos.databinding.FragmentOverviewReposBinding
import com.example.trendingrepos.domain.Repository


class OverviewReposFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewReposBinding.inflate(inflater, container, false)

        val adapter = RepositoryAdapter()
        binding.repoRecyclerList.adapter = adapter

        return (binding.root)
    }


}
