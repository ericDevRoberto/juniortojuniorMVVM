package com.example.juniortojuniormvvm.di

import com.example.juniortojuniormvvm.data.api.ApiCepService
import com.example.juniortojuniormvvm.data.dataSource.GetCepInformationDataSource
import com.example.juniortojuniormvvm.data.repository.GetCepInformationRepositoryImpl
import com.example.juniortojuniormvvm.domain.repository.GetCepInformationRepository
import com.example.juniortojuniormvvm.domain.userCases.GetCepInformationUserCase
import com.example.juniortojuniormvvm.presenter.historicFragment.HistoricViewModel
import com.example.juniortojuniormvvm.presenter.homeFragment.HomeViewModel
import com.example.juniortojuniormvvm.presenter.showCepfragment.ShowCepViewModel
import com.example.lolgg.core.apiServiceCore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val URL_CEP = "https://viacep.com.br/ws/"

val apiModules = module {
    single{ apiServiceCore(URL_CEP, ApiCepService::class.java)}
    single { GetCepInformationDataSource(service = get()) }
    single<GetCepInformationRepository> { GetCepInformationRepositoryImpl(dataSource = get()) }
}

val domainModules = module {

    factory { GetCepInformationUserCase(repository = get()) }
}

val viewModelModules = module {
    viewModel { HomeViewModel(get()) }
    viewModel { ShowCepViewModel() }
    viewModel {HistoricViewModel()}
}