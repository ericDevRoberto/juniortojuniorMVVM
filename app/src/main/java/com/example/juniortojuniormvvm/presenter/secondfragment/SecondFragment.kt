package com.example.juniortojuniormvvm.presenter.secondfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.juniortojuniormvvm.R
import com.example.juniortojuniormvvm.databinding.FragmentSecondBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondViewModel by viewModel()
    private val args: SecondFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSecondBinding.inflate(inflater, container, false).apply {
        binding = this
        init()
    }.root

    private fun init() {
        setListeners()
        setObservables()
        viewModel.getArgs(args.text)
    }

    private fun setObservables() {
        viewModel.action.observe(viewLifecycleOwner){ action ->
            when(action){
                SecondViewModel.SecondAction.GoBack -> goBack()
                is SecondViewModel.SecondAction.PutTextOnView -> setTextOnView(action.text)
            }
        }
    }

    private fun setListeners() {
        binding.buttonSecond.setOnClickListener {
            viewModel.goBack()
        }
    }

    private fun goBack() {
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }

    private fun setTextOnView(text: String){
        binding.textviewSecond.text = text
    }
}