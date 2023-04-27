package com.launcher.pandabox.controller.fragments.parentFragment

import android.graphics.drawable.Drawable

class UsageStatsModel {
    var __packgeName // packge name
            : CharSequence? = null
    var __appTime //App name
            : CharSequence? = null


    constructor(__packgeName: CharSequence?, __appTime: CharSequence?) {
        this.__packgeName = __packgeName
        this.__appTime = __appTime

    }
}