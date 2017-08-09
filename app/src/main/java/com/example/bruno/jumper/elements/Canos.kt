package com.example.bruno.jumper.elements

import android.content.Context
import android.graphics.Canvas
import com.example.bruno.jumper.graphics.Tela
import java.util.*

/**
 * Created by Bruno Melo on 08/08/17.
 */

class Canos(context: Context) {

    private val quantidadeCanos: Int = 5
    private val distanciaCanos: Float = 250F
    private val canosList: ArrayList<Cano> = ArrayList()

    init {
        val tela = Tela(context)
        for (i in 0..quantidadeCanos) {
            val cano: Cano = Cano(tela, distanciaCanos * i)
            canosList.add(cano)
        }
    }

    fun inicializaCanos(canvas: Canvas) {
       canosList.forEach { cano ->
           cano.desenhaCanoInferior(canvas)
           cano.moveCano()
       }
    }
}