package kr.co.mvvmsample.di

import kr.co.mvvmsample.viewmodel.MainViewModel
import kr.co.mvvmsample.viewmodel.TestViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    factory { MainViewModel() }
}

val viewModelModule = module {
    viewModel { TestViewModel() }
}