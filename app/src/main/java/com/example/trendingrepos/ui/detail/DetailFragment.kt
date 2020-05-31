package com.example.trendingrepos.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.trendingrepos.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        val repositoryArgs = DetailFragmentArgs.fromBundle(requireArguments()).repositoryArg

        val viewModelFactory = DetailViewModelFactory(repositoryArgs)
        val detailViewModel =
            ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding.repository = detailViewModel.repository.value
        return binding.root
    }


}