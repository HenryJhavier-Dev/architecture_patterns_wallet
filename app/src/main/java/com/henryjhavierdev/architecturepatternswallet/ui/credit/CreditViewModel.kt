package com.henryjhavierdev.architecturepatternswallet.ui.credit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreditViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Credit Fragment"
    }
    val text: LiveData<String> = _text

}