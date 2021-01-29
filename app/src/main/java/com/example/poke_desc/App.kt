package com.example.poke_desc

import android.app.Application
import com.example.poke_desc.di.module.appModule
import com.example.poke_desc.di.module.repositoryModule
import com.example.poke_desc.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application (){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }
    }
}