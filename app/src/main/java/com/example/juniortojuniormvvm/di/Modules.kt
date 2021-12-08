package com.example.juniortojuniormvvm.di

import androidx.room.Room
import com.example.juniortojuniormvvm.data.api.ApiCepService
import com.example.juniortojuniormvvm.data.dataBase.DataBase
import com.example.juniortojuniormvvm.data.dataSource.CepDataBaseInsertDataSource
import com.example.juniortojuniormvvm.data.dataSource.GetCepInformationDataSource
import com.example.juniortojuniormvvm.data.repository.CepDataBaseInsertRepositoryImpl
import com.example.juniortojuniormvvm.data.repository.GetCepInformationRepositoryImpl
import com.example.juniortojuniormvvm.domain.repository.CepDataBaseInsertRepository
import com.example.juniortojuniormvvm.domain.repository.GetCepInformationRepository
import com.example.juniortojuniormvvm.domain.userCases.CepDataBaseInsertUseCase
import com.example.juniortojuniormvvm.domain.userCases.GetCepInformationUserCase
import com.example.juniortojuniormvvm.presenter.historicFragment.HistoricViewModel
import com.example.juniortojuniormvvm.presenter.homeFragment.HomeViewModel
import com.example.juniortojuniormvvm.presenter.showCepfragment.ShowCepViewModel
import com.example.lolgg.core.apiServiceCore
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val NAME_DATA_BASE = "database"
private const val URL_CEP = "https://viacep.com.br/ws/"

val apiModules = module {
    single { apiServiceCore(URL_CEP, ApiCepService::class.java) }
    single { GetCepInformationDataSource(service = get()) }
    single<GetCepInformationRepository> { GetCepInformationRepositoryImpl(dataSource = get()) }
}

val dataBaseModules = module {
    single { Room.databaseBuilder(get(), DataBase::class.java, NAME_DATA_BASE).build() }
    single { get<DataBase>().cepDataBaseDao }
    single { CepDataBaseInsertDataSource(cepDataBaseDao = get()) }
    single<CepDataBaseInsertRepository> { CepDataBaseInsertRepositoryImpl(dataSource = get()) }
}

val domainModules = module {
    factory { GetCepInformationUserCase(repository = get()) }
    factory { CepDataBaseInsertUseCase(repository = get()) }
}

val viewModelModules = module {
    viewModel { HomeViewModel(getCepInformation = get(), cepDataBaseInsertUseCase = get()) }
    viewModel { ShowCepViewModel() }
    viewModel { HistoricViewModel() }
}

