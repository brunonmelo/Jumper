package com.example.bruno.jumper.elements

import android.graphics.Canvas
import android.graphics.Paint
import com.example.bruno.jumper.graphics.Cores

/**
 * Created by Bruno on 14/07/2017.
 */
class Passaro(var altura: Float = 100F) {

    private val X: Float = 100F
    private val RAIO: Float = 40F
    private val VERMELHO: Paint? = Cores.corDoPassaro()

    fun desenhaNoCanvas(canvas: Canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO)
    }

    fun cai() {
        altura += 5
    }
}