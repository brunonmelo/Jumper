package com.example.bruno.jumper.graphics

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface

/**
 * Created by Bruno on 14/07/2017.
 */

object Cores : Paint() {
    fun corDoPassaro(): Paint {
        val paint = Paint()
        paint.color = Color.RED
        return paint
    }

    fun corDoCano(): Paint {
        val paint = Paint()
        paint.color = Color.GREEN
        return paint
    }

    fun  corDoNumero(): Paint {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.textSize = 80F
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.setShadowLayer(2F, 3F, 3F, Color.BLACK)
        return paint
    }
}