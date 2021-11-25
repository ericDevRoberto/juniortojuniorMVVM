package com.example.juniortojuniormvvm.presenter.secondfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    internal sealed class SecondAction {
        data class PutTextOnView(val text: String) : SecondAction()
        object GoBack : SecondAction()
    }

    internal val action = MutableLiveData<SecondAction>()

    fun getArgs(text: String){
        action.postValue(SecondAction.PutTextOnView(text))
    }

    fun goBack(){
        action.postValue(SecondAction.GoBack)
    }
}