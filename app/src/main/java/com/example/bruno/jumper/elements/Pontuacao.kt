package com.example.bruno.jumper.elements

import android.graphics.Canvas
import android.graphics.Paint
import com.example.bruno.jumper.graphics.Cores

/**
 * Created by Bruno Melo on 16/08/17.
 */

class Pontuacao(val passaro: Passaro, val canos: Canos) {

    private var pontuacao: Int = 0
    private val corDoNumero: Paint = Cores.corDoNumero()

    fun marcaPontuacao() {
        if(canos.marcaPontuacao(passaro))
            pontuacao++
    }

    fun desenhaPontuacao(canvas: Canvas) {
        marcaPontuacao()
        canvas.drawText(pontuacao.toString(), 50F, 100F, corDoNumero)
    }

}