package com.example.bruno.jumper.graphics

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager

/**
 * Created by Bruno on 17/07/2017.
 */
class Tela(context: Context) {
    private var metrics = DisplayMetrics()
    val altura: Int
    val largura: Int

    init {
        val wm: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(metrics)
            altura = metrics.heightPixels
            largura = metrics.widthPixels
        } else {
            val mGetRawH = Display::class.java.getMethod("getRawHeight")
            val mGetRawW = Display::class.java.getMethod("getRawWidth")
            altura = mGetRawH.invoke(display) as Int
            largura = mGetRawW.invoke(display) as Int
        }
    }

}