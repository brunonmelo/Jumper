package com.example.bruno.jumper.elements

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import com.example.bruno.jumper.graphics.Cores
import com.example.bruno.jumper.graphics.Tela

/**
 * Created by Bruno on 14/07/2017.
 */
class Passaro(val tela: Tela) {

    private var altura: Float = 60F
    private val X: Float = 100F
    private val RAIO: Float = 40F
    private val VERMELHO: Paint? = Cores.corDoPassaro()
    private val aceleracao = 1.5
    private var velocidade: Double = -10.0

    fun desenhaNoCanvas(canvas: Canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO)
    }

    fun cai() {
        val chegouNoChao = altura + RAIO >= tela.altura
        if (!chegouNoChao) {
            altura += (velocidade / 4).toFloat()
            velocidade += aceleracao
        }
    }

    fun pula() {
        val chegouNoTeto = altura - RAIO < 0
        if (!chegouNoTeto) velocidade = -40.0
    }
}