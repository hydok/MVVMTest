package kr.co.mvvmsample

import android.app.Application
import kr.co.mvvmsample.di.myModule
import kr.co.mvvmsample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MvvmApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MvvmApplication)
            modules(myModule)
            modules(viewModelModule)
        }
    }
}