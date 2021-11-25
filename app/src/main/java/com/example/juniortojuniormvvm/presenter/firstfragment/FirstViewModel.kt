package com.example.juniortojuniormvvm.presenter.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel: ViewModel() {

    sealed class FirstAction{
        data class GetName(val text: String): FirstAction()
    }

    internal val action = MutableLiveData<FirstAction>()
    private var inputText = String()

    fun getTextFromEditText(text: String){
        inputText = text
    }

    fun getTextAndGotoNextView(){
        action.postValue(FirstAction.GetName(inputText))
    }
}