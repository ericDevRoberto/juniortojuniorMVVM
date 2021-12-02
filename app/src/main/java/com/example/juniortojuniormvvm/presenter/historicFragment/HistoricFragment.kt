package com.example.juniortojuniormvvm.presenter.historicFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.juniortojuniormvvm.databinding.HistoricFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoricFragment : Fragment() {

    private val viewModel: HistoricViewModel by viewModel()
    private lateinit var binding: HistoricFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = HistoricFragmentBinding.inflate(inflater, container, false).apply {
        binding = this
    }.root


}