package com.example.bruno.jumper.engine

import com.example.bruno.jumper.elements.Cano
import com.example.bruno.jumper.elements.Canos
import com.example.bruno.jumper.elements.Passaro

/**
 * Created by Bruno Melo on 18/08/17.
 */

class VerificadorDeColisao(private val canos: Canos,
                           private val passaro: Passaro,
                           private val som: Som) {

    fun verificaColisao(): Boolean {
        val canosList = canos.getCanosList()
        canosList.forEach { cano ->
            if (temColisaoHorizontal(passaro, cano)
                    && temColisaoVertical(passaro, cano)) {
                som.somColisao()
                return true
            }
        }
        return false
    }

    private fun temColisaoVertical(passaro: Passaro, cano: Cano) =
            passaro.altura() - passaro.RAIO < cano.alturaDoCanoSuperior ||
                    passaro.altura() + passaro.RAIO > cano.alturaDoCanoInferior

    private fun temColisaoHorizontal(passaro: Passaro, cano: Cano) =
            passaro.X + passaro.RAIO > cano.posicao &&
                    passaro.X - passaro.RAIO < cano.posicao + cano.LARGURA_DO_CANO
}