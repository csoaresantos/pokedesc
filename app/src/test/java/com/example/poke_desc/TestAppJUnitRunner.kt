package com.example.poke_desc

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class TestAppJUnitRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, KoinTestApp::class.java.name, context)
    }
}