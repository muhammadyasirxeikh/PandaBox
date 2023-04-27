package com.launcher.pandabox.storage

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceStorrage {

    val PREF_NAME = "com.codecoy.pandabox"
    val MODE = Context.MODE_PRIVATE

    fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, MODE)
    }

    fun getEditor(context: Context): SharedPreferences.Editor? {
        return getPreferences(context).edit()
    }

    fun setStringValue(context: Context?, key: String?, value: String?) {
       getEditor(context!!)?.putString(key, value)?.commit()
    }
    fun getStringValue(context: Context?, key: String?, default_value: String?): String? {
        return getPreferences(
            context!!
        ).getString(key, default_value)
    }

    fun setListvalue(context: Context?, key: String?, value: List<String>?) {
        getEditor(context!!)?.putStringSet(key, value?.toSet())?.commit()
    }

    fun getListValue(context:Context? , key: String?): List<String>? {
        return getPreferences(
            context!!
        ).getStringSet(key, null)?.toList()
    }
}