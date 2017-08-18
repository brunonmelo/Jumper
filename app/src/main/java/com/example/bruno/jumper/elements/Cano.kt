package com.example.bruno.jumper.elements

import android.graphics.Canvas
import com.example.bruno.jumper.graphics.Cores
import com.example.bruno.jumper.graphics.Tela


/**
 * Created by Bruno Melo on 03/08/17.
 */

class Cano(private val tela: Tela, var posicao: Float) {
    val LARGURA_DO_CANO = 70F
    private val ALTURA_BASE = 70F

    private val randomValue = valorAleatorio()

    val alturaDoCanoInferior = tela.altura.toFloat() - ALTURA_BASE - randomValue
    val alturaDoCanoSuperior = ALTURA_BASE + randomValue

    private val corDoCano = Cores.corDoCano()
    private var pontuado = false

    private fun valorAleatorio(): Float {
        return (Math.random() * 275).toFloat()
    }

    fun desenhaCanoInferior(canvas: Canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.altura.toFloat(), corDoCano)
    }

    fun desenhaCanoSuperior(canvas: Canvas) {
        canvas.drawRect(posicao, 0F, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, corDoCano)
    }

    fun moveCano() {
        posicao -= 3
    }

    fun saiuDaTela(): Boolean {
        return posicao + LARGURA_DO_CANO < 0
    }

    fun pontua() {
        pontuado = true
    }

    fun isPontuado(): Boolean {
        return pontuado
    }

}