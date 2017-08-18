package com.example.bruno.jumper.elements

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import com.example.bruno.jumper.graphics.Cores
import com.example.bruno.jumper.graphics.Tela

/**
 * Created by Bruno Melo on 18/08/17.
 */
class GameOver(private val tela: Tela) {

    private val vermelho: Paint = Cores.corDoGameOver()
    private val texto: String = "Fim do Jogo"
    fun desenhaGameOverNaTela(canvas: Canvas) {

        canvas.drawText(texto,
                (pegarCentroTexto()),
                (tela.altura / 2).toFloat(),
                vermelho)
    }

    fun pegarCentroTexto(): Float {
        val limiteDoTexto = Rect()
        vermelho.getTextBounds(texto, 0, texto.length, limiteDoTexto)
        return (tela.largura / 2) - limiteDoTexto.exactCenterX()
    }
}