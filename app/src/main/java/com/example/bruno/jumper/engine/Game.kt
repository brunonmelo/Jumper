package com.example.bruno.jumper.engine

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.example.bruno.jumper.R
import com.example.bruno.jumper.elements.Passaro
import com.example.bruno.jumper.graphics.Tela

/**
 * Created by Bruno on 13/07/2017.
 */

class Game(context: Context): SurfaceView(context), Runnable {
    private var isRunning: Boolean = false
    private val mHolder: SurfaceHolder = holder
    private lateinit var passaro: Passaro
    private lateinit var background: Bitmap
    private lateinit var back: Bitmap

    init {
        inicializaElementos()
    }

    fun inicializaElementos() {
        val tela = Tela(context)
        passaro = Passaro()
        back = BitmapFactory.decodeResource(resources, R.drawable.background)
        background = Bitmap.createScaledBitmap(back, tela.largura, tela.altura, false)
    }

    override fun run() {
        while (isRunning) {
            if (!mHolder.surface.isValid) continue

            val canvas = mHolder.lockCanvas()

            canvas.drawBitmap(background,0F,0F, null)
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