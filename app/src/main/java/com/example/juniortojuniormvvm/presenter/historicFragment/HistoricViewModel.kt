package com.example.juniortojuniormvvm.presenter.historicFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HistoricViewModel : ViewModel() {

    internal sealed class Action{

    }

    internal val action = MutableLiveData<Action>()
}