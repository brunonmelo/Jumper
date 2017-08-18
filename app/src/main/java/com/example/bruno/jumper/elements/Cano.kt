package com.example.bruno.jumper.elements

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import com.example.bruno.jumper.R
import com.example.bruno.jumper.graphics.Tela


/**
 * Created by Bruno Melo on 03/08/17.
 */

class Cano(tela: Tela, var posicao: Float, context: Context) {
    val LARGURA_DO_CANO = 70F
    private val ALTURA_BASE = 70F

    private val randomValue = valorAleatorio()

    val alturaDoCanoInferior = tela.altura.toFloat() - ALTURA_BASE - randomValue
    val alturaDoCanoSuperior = ALTURA_BASE + randomValue

    private var pontuado = false
    private val bp: Bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.cano)
    private val canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO.toInt(), alturaDoCanoInferior.toInt(), false)
    private val canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_DO_CANO.toInt(), alturaDoCanoSuperior.toInt(), false)

    private fun valorAleatorio(): Float = (Math.random() * 275).toFloat()

    fun desenhaCanoInferior(canvas: Canvas) {
        canvas.drawBitmap(canoInferior, posicao, alturaDoCanoInferior, null)
    }

    fun desenhaCanoSuperior(canvas: Canvas) {
        canvas.drawBitmap(canoSuperior, posicao, 0F, null)
    }

    fun moveCano() {
        posicao -= 3
    }

    fun saiuDaTela(): Boolean = posicao + LARGURA_DO_CANO < 0

    fun pontua() {
        pontuado = true
    }

    fun isPontuado(): Boolean = pontuado

}