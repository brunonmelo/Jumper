package com.example.bruno.jumper.engine

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import com.example.bruno.jumper.R
import com.example.bruno.jumper.elements.Cano
import com.example.bruno.jumper.elements.Canos
import com.example.bruno.jumper.elements.Passaro
import com.example.bruno.jumper.graphics.Tela

/**
* Created by Bruno on 13/07/2017.
*/

class Game(context: Context): SurfaceView(context), Runnable, View.OnTouchListener {
    private var isRunning: Boolean = false
    private val mHolder: SurfaceHolder = holder
    private lateinit var passaro: Passaro
    private lateinit var canos: Canos
    private lateinit var background: Bitmap
    private lateinit var back: Bitmap

    init {
        inicializaElementos()
    }

    fun inicializaElementos() {
        val tela = Tela(context)
        passaro = Passaro(tela)
        canos = Canos(context)
        back = BitmapFactory.decodeResource(resources, R.drawable.background)
        background = Bitmap.createScaledBitmap(back, tela.largura, tela.altura, false)
        setOnTouchListener(this)
    }

    override fun run() {
        while (isRunning) {
            if (!mHolder.surface.isValid) continue

            val canvas = mHolder.lockCanvas()

            canvas.drawBitmap(background,0F,0F, null)
            passaro.desenhaNoCanvas(canvas)
            passaro.cai()
            canos.inicializaCanos(canvas)

            mHolder.unlockCanvasAndPost(canvas)
        }
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        passaro.pula()
        return false
    }

    fun inicia() {
        isRunning = true
    }

    fun pausa() {
        isRunning = false
    }

}