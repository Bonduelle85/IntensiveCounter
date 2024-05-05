package com.example.intensivecounter.data

import android.content.Context
import com.example.intensivecounter.R


interface PermanentStorage {

    fun save(value: Int, key: String)

    fun read(key: String, default: Int): Int

    class Base(context: Context) : PermanentStorage {

        private val sharedPreferences = context.getSharedPreferences(
            context.getString(R.string.app_name), Context.MODE_PRIVATE
        )

        override fun save(value: Int, key: String) {
            sharedPreferences.edit()
                .putInt(key, value)
                .apply()
        }

        override fun read(key: String, default: Int): Int {
            return sharedPreferences.getInt(key, default)
        }
    }
}