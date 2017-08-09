package com.example.bruno.jumper.elements

import android.graphics.Canvas
import com.example.bruno.jumper.graphics.Cores
import com.example.bruno.jumper.graphics.Tela


/**
 * Created by Bruno Melo on 03/08/17.
 */

class Cano(val tela: Tela, distanciaCanos: Float) {
    private val larguraDoCano = 80F
    private val alturaBase = 150F
    private val pontoInicialDoCano = distanciaCanos + tela.altura.toFloat()
    private val alturaDoCano = tela.altura.toFloat() - alturaBase
    private val corDoCano = Cores.corDoCano()
    private var posicao = pontoInicialDoCano + larguraDoCano

    fun desenhaCanoInferior(canvas: Canvas){
        canvas.drawRect(posicao, alturaDoCano, posicao + larguraDoCano, tela.altura.toFloat(), corDoCano)
    }

    fun moveCano(){
        posicao -= 3
    }

}