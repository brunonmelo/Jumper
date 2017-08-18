package com.example.bruno.jumper.engine

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import com.example.bruno.jumper.R
import com.example.bruno.jumper.elements.Canos
import com.example.bruno.jumper.elements.GameOver
import com.example.bruno.jumper.elements.Passaro
import com.example.bruno.jumper.elements.Pontuacao
import com.example.bruno.jumper.graphics.Tela

/**
 * Created by Bruno on 13/07/2017.
 */

class Game(context: Context) : SurfaceView(context), Runnable, View.OnTouchListener {
    private var isRunning: Boolean = false
    private val mHolder: SurfaceHolder = holder
    private val canos: Canos = Canos(context)
    private val tela = Tela(context)
    private val back: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.background)
    private val som: Som = Som(context)
    private val passaro = Passaro(tela, context, som)
    private val background = Bitmap.createScaledBitmap(back, back.width, tela.altura, false)
    private val pontuacao = Pontuacao(passaro, canos, som)
    private val verificadorDeColisao = VerificadorDeColisao(canos, passaro, som)

    init {
        setOnTouchListener(this)
    }

    override fun run() {
        while (isRunning) {
            if (!mHolder.surface.isValid) continue

            val canvas = mHolder.lockCanvas()

            canvas.drawBitmap(background, 0F, 0F, null)
            passaro.desenhaNoCanvas(canvas)
            passaro.cai()
            canos.desenhaCanos(canvas)
            canos.move()

            if(verificadorDeColisao.verificaColisao()) {
                GameOver(tela).desenhaGameOverNaTela(canvas)
                som.paraSom()
                isRunning = false
            }

            pontuacao.desenhaPontuacao(canvas)

            mHolder.unlockCanvasAndPost(canvas)
        }
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        passaro.pula()
        return false
    }

    fun inicia() {
        isRunning = true
    }

    fun pausa() {
        isRunning = false
    }

}