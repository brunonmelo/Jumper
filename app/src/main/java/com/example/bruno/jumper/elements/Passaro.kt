package com.example.bruno.jumper.elements

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import com.example.bruno.jumper.graphics.Cores

/**
 * Created by Bruno on 14/07/2017.
 */
class Passaro(var altura: Float = 60F) {

    private val X: Float = 100F
    private val RAIO: Float = 40F
    private val VERMELHO: Paint? = Cores.corDoPassaro()
    private val aceleracao = 1.5
    private var velocidade: Double = -10.0

    fun desenhaNoCanvas(canvas: Canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO)
    }

    fun cai() {
        altura += (velocidade / 4).toFloat()
        velocidade += aceleracao
    }

    fun pula() {
        velocidade = -40.0
    }
}