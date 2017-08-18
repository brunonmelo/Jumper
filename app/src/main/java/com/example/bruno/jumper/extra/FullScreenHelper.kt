package com.example.bruno.jumper.extra

import android.R
import android.app.Activity
import android.os.Build
import android.view.View

/**
 * Created by Bruno on 13/07/2017.
 */
class FullScreenHelper(activity: Activity) {
    init {
        var newUiOptions = R.attr.uiOptions

        if (Build.VERSION.SDK_INT >= 14) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }

        // Status bar hiding: Backwards compatible to Jellybean
        if (Build.VERSION.SDK_INT >= 16) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        if (Build.VERSION.SDK_INT >= 18) {
            newUiOptions = newUiOptions xor View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }

        activity.window.decorView.systemUiVisibility = newUiOptions
    }
}