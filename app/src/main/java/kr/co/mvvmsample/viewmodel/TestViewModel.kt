package kr.co.mvvmsample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {

    val data  = MutableLiveData<String>()

    init {
        data.value = "안녕하세요 ^^"

    }

    fun getData() : String? = data.value


}