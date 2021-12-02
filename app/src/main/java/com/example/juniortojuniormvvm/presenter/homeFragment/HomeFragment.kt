package com.example.juniortojuniormvvm.presenter.homeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.juniortojuniormvvm.databinding.FragmentFirstBinding
import com.example.juniortojuniormvvm.presenter.homeFragment.HomeViewModel.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFirstBinding.inflate(inflater, container, false).apply {
        binding = this
        init()
    }.root

    private fun init() {
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        viewModel.action.observe(viewLifecycleOwner) { action ->
            when (action) {
                is FirstAction.GetName -> goToNextPage(action.text)
            }
        }
    }

    private fun setListeners() {
        binding.buttonFirst.setOnClickListener {
            viewModel.getTextAndGotoNextView()
        }
        binding.textviewFirst.addTextChangedListener {
            viewModel.getTextFromEditText(it.toString())
        }
    }

    private fun goToNextPage(text: String) {
        findNavController().navigate(HomeFragmentDirections.actionFirstFragmentToSecondFragment(text))
    }
}