package com.example.kantiorganizer.ui.data

import android.content.Context
import android.content.SharedPreferences
import com.example.kantiorganizer.ui.dashboard.Grade
import com.example.kantiorganizer.ui.home.HomeFragment
import com.example.kantiorganizer.ui.settings.SettingsFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.kantiorganizer.ui.home.Event

class DataManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("kanti_organizer_data", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveEvents(events: List<Event>) {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(events)
        editor.putString("events", json)
        editor.apply()
    }


    fun getEvents(): List<Event> {
        val json = sharedPreferences.getString("events", null)
        return if (json != null) {
            val type = object : TypeToken<List<Event>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }

    fun saveGrades(grades: List<Grade>) {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(grades)
        editor.putString("grades", json)
        editor.apply()
    }

    fun getGrades(): List<Grade> {
        val json = sharedPreferences.getString("grades", null)
        return if (json != null) {
            val type = object : TypeToken<List<Grade>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }



    fun clearGrades() {
        val editor = sharedPreferences.edit()
        editor.remove("grades")
        editor.apply()
    }

    fun clearEvents() {
        val editor = sharedPreferences.edit()
        editor.remove("events")
        editor.apply()
    }

    fun saveDarkModePreference(isDarkMode: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean("dark_mode", isDarkMode)
        editor.apply()
    }

    fun getDarkModePreference(): Boolean {
        return sharedPreferences.getBoolean("dark_mode", false)
    }
}
