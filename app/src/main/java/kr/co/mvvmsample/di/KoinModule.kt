package kr.co.mvvmsample.di

import kr.co.mvvmsample.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    factory { MainViewModel() }
}