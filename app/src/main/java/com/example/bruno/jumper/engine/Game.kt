package com.example.bruno.jumper.engine

import android.content.Context
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.bruno.jumper.elements.Passaro

/**
 * Created by Bruno on 13/07/2017.
 */

class Game(context: Context) : SurfaceView(context), Runnable {

    private var isRunning: Boolean = false
    private val mHolder: SurfaceHolder = holder
    private val passaro = Passaro()

    override fun run() {
        while (isRunning) {
            if (!mHolder.surface.isValid) continue

            val canvas = mHolder.lockCanvas()

            passaro.desenhaNoCanvas(canvas)
            passaro.cai()

            mHolder.unlockCanvasAndPost(canvas)
        }
    }

    fun inicia() {
        isRunning = true
    }

    fun pausa() {
        isRunning = false
    }
}