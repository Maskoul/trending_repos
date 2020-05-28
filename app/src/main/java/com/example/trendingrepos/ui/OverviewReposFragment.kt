package com.example.trendingrepos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.trendingrepos.databinding.FragmentOverviewReposBinding


class OverviewReposFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewReposBinding.inflate(inflater,container,false)

        return (binding.root)
    }


}
