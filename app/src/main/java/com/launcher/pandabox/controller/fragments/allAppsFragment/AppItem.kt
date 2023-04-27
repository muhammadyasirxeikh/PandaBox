package com.launcher.pandabox.controller.fragments.allAppsFragment

import android.graphics.drawable.Drawable

class AppItem {
     var __packgeName // packge name
            : CharSequence? = null
     var __appName //App name
            : CharSequence? = null
     var __appIcon //App icon
            : Drawable? = null

    var __isSelect //App icon
            : Boolean = false

    constructor(__packgeName: CharSequence?, __appName: CharSequence?, __appIcon: Drawable?) {
        this.__packgeName = __packgeName
        this.__appName = __appName
        this.__appIcon = __appIcon
    }
}