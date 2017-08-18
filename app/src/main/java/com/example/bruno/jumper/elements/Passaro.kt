package com.example.bruno.jumper.elements

import android.graphics.Canvas
import android.graphics.Paint
import com.example.bruno.jumper.graphics.Cores
import com.example.bruno.jumper.graphics.Tela

/**
 * Created by Bruno on 14/07/2017.
 */
class Passaro(val tela: Tela) {

    private var altura: Float = 100F
    val X: Float = 70F
    val RAIO: Float = 40F
    private val VERMELHO: Paint? = Cores.corDoPassaro()
    private val aceleracao = 1.4
    private var velocidade: Double = -10.0

    fun desenhaNoCanvas(canvas: Canvas) {
        canvas.drawCircle(X, altura, RAIO, VERMELHO)
    }

    fun cai() {
        val chegouNoChao = altura + RAIO >= tela.altura
        if (!chegouNoChao) {
            altura += (velocidade / 4).toFloat()
            velocidade += aceleracao
        } else {
            velocidade = 0.0
            altura = tela.altura.toFloat() - RAIO
        }
    }

    fun pula() {
        val chegouNoTeto = altura - RAIO < 0
        if (!chegouNoTeto) velocidade = -30.0
        else {
            velocidade = 0.0
            altura = 0F + RAIO
        }
    }

    fun altura(): Float = altura
}