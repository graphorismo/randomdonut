package ru.graphorismo.randomdonut

import android.app.Application
import ru.graphorismo.randomdonut.data.repository.DonutRepository

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DonutRepository.init()
    }
}