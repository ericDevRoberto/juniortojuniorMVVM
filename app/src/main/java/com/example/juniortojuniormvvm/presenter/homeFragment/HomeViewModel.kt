package com.example.juniortojuniormvvm.presenter.homeFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.juniortojuniormvvm.domain.userCases.GetCepInformationUserCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getCepInformation: GetCepInformationUserCase): ViewModel() {

    sealed class FirstAction{
        data class GetName(val text: String): FirstAction()
    }

    internal val action = MutableLiveData<FirstAction>()
    private var inputText = String()

    fun getTextFromEditText(text: String){
        inputText = text
    }

    fun getTextAndGotoNextView(){
        viewModelScope.launch {
            runCatching { getCepInformation(inputText) }
                .onSuccess {
                    action.postValue(FirstAction.GetName(it.address))
                }
                .onFailure {
                    action.postValue(FirstAction.GetName("ERROR"))
                }
        }
    }
}