package com.example.juniortojuniormvvm

import android.app.Application
import com.example.juniortojuniormvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationActivity : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApplicationActivity)
            modules(
                listOf(
                    viewModelModules,
                    domainModules,
                    apiModules,
                )
            )
        }
    }
}