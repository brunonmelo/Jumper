package com.example.bruno.jumper.elements

import android.graphics.Canvas
import android.graphics.Paint
import com.example.bruno.jumper.engine.Som
import com.example.bruno.jumper.graphics.Cores

/**
 * Created by Bruno Melo on 16/08/17.
 */

class Pontuacao(private val passaro: Passaro, private val canos: Canos, private val som: Som) {

    private var pontuacao: Int = 0
    private val corDoNumero: Paint = Cores.corDoNumero()

    fun marcaPontuacao() {
        if(canos.marcaPontuacao(passaro)) {
            pontuacao++
            som.somPontos()
        }
    }

    fun desenhaPontuacao(canvas: Canvas) {
        marcaPontuacao()
        canvas.drawText(pontuacao.toString(), 50F, 100F, corDoNumero)
    }

}