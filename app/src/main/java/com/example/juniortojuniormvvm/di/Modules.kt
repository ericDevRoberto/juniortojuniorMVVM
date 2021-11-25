package com.example.juniortojuniormvvm.di

import com.example.juniortojuniormvvm.presenter.firstfragment.FirstViewModel
import com.example.juniortojuniormvvm.presenter.secondfragment.SecondViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { FirstViewModel() }
    viewModel { SecondViewModel() }
}