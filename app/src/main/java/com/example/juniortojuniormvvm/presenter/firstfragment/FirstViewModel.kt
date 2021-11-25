package com.example.juniortojuniormvvm.presenter.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.juniortojuniormvvm.domain.userCases.GetCepInformationUserCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstViewModel(private val getCepInformation: GetCepInformationUserCase): ViewModel() {

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
            kotlin.runCatching { getCepInformation(inputText) }
                .onSuccess {
                    action.postValue(FirstAction.GetName(it.endereco))
                }
                .onFailure {
                    action.postValue(FirstAction.GetName("ERROR"))
                }
        }
    }
}