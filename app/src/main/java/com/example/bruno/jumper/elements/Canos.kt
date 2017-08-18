package com.example.bruno.jumper.elements

import android.content.Context
import android.graphics.Canvas
import com.example.bruno.jumper.graphics.Tela
import java.util.*

/**
 * Created by Bruno Melo on 08/08/17.
 */

class Canos(private val context: Context) {

    private val quantidadeCanos: Int = 5
    private val distanciaCanos: Float = 200F
    private val canosList: ArrayList<Cano> = ArrayList()
    private val tela = Tela(context)

    init {
        var dist: Float = tela.largura.toFloat()
        for (i in 0..quantidadeCanos) {
            val cano = Cano(tela, dist + (distanciaCanos * 2), context)
            canosList.add(cano)
            dist += distanciaCanos
        }
    }

    fun desenhaCanos(canvas: Canvas) {
        canosList.forEach { cano ->
            cano.desenhaCanoInferior(canvas)
            cano.desenhaCanoSuperior(canvas)
        }
    }

    fun move() {
        val iterator = canosList.listIterator()
        while (iterator.hasNext()) {
            val cano = iterator.next()
            cano.moveCano()
            if (cano.saiuDaTela()) {
                iterator.remove()
                iterator.add(Cano(tela, getMaximo(), context))
            }
        }
    }

    private fun getMaximo(): Float {
        val maximo = canosList
                .map { it.posicao }
                .max()
                ?: 0F
        return maximo + distanciaCanos
    }

    fun marcaPontuacao(passaro: Passaro): Boolean {
        canosList.forEach { cano ->
            if (cano.posicao + cano.LARGURA_DO_CANO < passaro.X + passaro.RAIO && !cano.isPontuado()) {
                cano.pontua()
                return true
            }
        }
        return false
    }

    fun getCanosList(): ArrayList<Cano> = canosList
}