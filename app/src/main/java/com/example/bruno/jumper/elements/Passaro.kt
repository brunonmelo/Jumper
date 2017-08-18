package com.example.bruno.jumper.elements

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.bruno.jumper.R
import com.example.bruno.jumper.engine.Som
import com.example.bruno.jumper.graphics.Tela

/**
 * Created by Bruno on 14/07/2017.
 */
class Passaro(private val tela: Tela, context: Context, private val som: Som) {

    private var altura: Float = 100F
    val X: Float = 70F
    val RAIO: Float = 40F
    private val aceleracao = 1.4
    private var velocidade: Double = -10.0
    private val bp: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.passaro)
    private val passaro: Bitmap = Bitmap.createScaledBitmap(bp, (RAIO * 2).toInt(), (RAIO * 2).toInt(), false)

    init {

    }

    fun desenhaNoCanvas(canvas: Canvas) {
        canvas.drawBitmap(passaro, X - RAIO, altura - RAIO, null)
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
        if (!chegouNoTeto) {
            velocidade = -30.0
            som.somPulo()
        } else {
            velocidade = 0.0
            altura = 0F + RAIO
        }
    }

    fun altura(): Float = altura
}