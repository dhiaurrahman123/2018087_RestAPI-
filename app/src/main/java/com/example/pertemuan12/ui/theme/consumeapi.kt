package com.example.pertemuan12.ui.theme

import android.app.Application
import com.example.pertemuan12.repository.AppContainer
import com.example.pertemuan12.repository.KontakContainer

class KontakAplikation: Application(){
    lateinit var container: AppContainer
    override fun onCreate(){
        super.onCreate()
        container = KontakContainer()
    }
}