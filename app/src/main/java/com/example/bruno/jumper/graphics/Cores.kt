package com.example.bruno.jumper.graphics

import android.graphics.Color
import android.graphics.Paint

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
}