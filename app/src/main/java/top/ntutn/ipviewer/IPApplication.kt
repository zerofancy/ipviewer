package top.ntutn.ipviewer

import android.app.Application
import android.content.Context

class IPApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    companion object {
        internal lateinit var context: Context
    }
}

object CommonUtil {
    fun getApplicationContext() = IPApplication.context
}