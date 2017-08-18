package com.example.bruno.jumper.engine

import android.content.Context
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import com.example.bruno.jumper.R

/**
 * Created by Bruno Melo on 18/08/17.
 */


class Som(context: Context) {
    private var soundPool: SoundPool
    private var somPulo: Int = 0
    private var somColisao: Int = 0
    private var somPontos: Int = 0

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundPool = SoundPool.Builder().setMaxStreams(3).build()
        } else {
            @Suppress("DEPRECATION")
            soundPool = SoundPool(3, AudioManager.STREAM_MUSIC, 0)
        }
        somPulo = soundPool.load(context, R.raw.pulo, 1)
        somColisao = soundPool.load(context, R.raw.colisao, 1)
        somPontos = soundPool.load(context, R.raw.pontos, 1)
    }

    fun somPulo() {
        soundPool.play(somPulo, 1F, 1F, 1, 0, 1F)
    }

    fun somColisao() {
        soundPool.play(somColisao,1F, 1F, 1, 0, 1F)
    }

    fun somPontos() {
        soundPool.play(somPontos,1F, 1F, 1, 0, 1F)
    }

    fun paraSom() {
        soundPool.unload(somPulo)
        soundPool.unload(somColisao)
        soundPool.unload(somPontos)
    }

}