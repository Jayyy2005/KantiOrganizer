package com.example.kantiorganizer

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val sharedPreferences = getSharedPreferences(
            "com.example.kantiorganizer.PREFERENCE_FILE_KEY",
            Context.MODE_PRIVATE
        )

        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)

        val nightMode = if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}
