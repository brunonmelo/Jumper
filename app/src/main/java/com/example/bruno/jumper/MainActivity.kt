package com.example.bruno.jumper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import com.example.bruno.jumper.engine.Game
import com.example.bruno.jumper.extra.FullScreenHelper

class MainActivity : AppCompatActivity() {

    private lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FullScreenHelper(this)

        game = Game(this)

        val container: FrameLayout = findViewById(R.id.container) as FrameLayout
        container.addView(game)
    }

    override fun onResume() {
        super.onResume()
        game.inicia()
        Thread(game).start()
    }

    override fun onPause() {
        super.onPause()
        game.pausa()
    }
}