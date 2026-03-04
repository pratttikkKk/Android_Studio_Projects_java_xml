package com.smartmechanic.app

import android.app.Application

class SmartMechanicApp : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: SmartMechanicApp
            private set
    }
}
