package com.example.juniortojuniormvvm.presenter.firstfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.example.juniortojuniormvvm.R
import com.example.juniortojuniormvvm.databinding.FragmentFirstBinding
import com.example.juniortojuniormvvm.presenter.firstfragment.FirstViewModel.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: FirstViewModel by viewModel()

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
                is FirstAction.GetName -> putnameCep(action.text)
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

    private fun putnameCep(endereco: String){
        binding.textviewFirst.setText(endereco)
    }

    private fun goToNextPage(text: String) {
        findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(text))
    }
}