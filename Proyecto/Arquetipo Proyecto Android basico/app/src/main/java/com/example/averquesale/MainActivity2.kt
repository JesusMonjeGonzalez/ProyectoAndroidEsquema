package com.example.averquesale

import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

    val audioAttributes = AudioAttributes.Builder()
        .setUsage(AudioAttributes.USAGE_GAME)
        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
        .build()
    val soundPool1 = SoundPool.Builder().setAudioAttributes(audioAttributes)
        .setMaxStreams(10).build()



        val audioManager: AudioManager=
            getSystemService(Context.AUDIO_SERVICE)
            as AudioManager

    val volume  = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

        val sound1 = soundPool1.load(this, R.raw.mario,1)
        val sound2 = soundPool1.load(this, R.raw.mariovida,1)
        val sound3 = soundPool1.load(this, R.raw.mariotuberia,1)
        val sound4 = soundPool1.load(this, R.raw.miau,1)

    var btnaudio1 = findViewById<Button>(R.id.button2)
        var btnaudio2 = findViewById<Button>(R.id.button3)
        var btnaudio3 = findViewById<Button>(R.id.button4)
        var btnaudio4 = findViewById<Button>(R.id.button5)
        var btnaudio5 = findViewById<Button>(R.id.button6)
        var btnaudio6 = findViewById<Button>(R.id.button7)
        btnaudio1.setOnClickListener{

            soundPool1.play(sound1,volume.toFloat(),volume.toFloat(),1,0,1f)

        }

        btnaudio2.setOnClickListener{

            soundPool1.play(sound2,volume.toFloat(),volume.toFloat(),1,0,1f)

        }
        btnaudio3.setOnClickListener{

            soundPool1.play(sound3,volume.toFloat(),volume.toFloat(),1,0,1f)

        }
        btnaudio4.setOnClickListener{

            soundPool1.play(sound4,volume.toFloat(),volume.toFloat(),1,0,1f)

        }

var mediaPlayer: MediaPlayer? = null
        mediaPlayer = MediaPlayer.create(this,R.raw.mariomoneda)

        btnaudio5.setOnClickListener{


            mediaPlayer?.start()
        }

        var mediaPlayer2: MediaPlayer? = null
        mediaPlayer2 = MediaPlayer.create(this,R.raw.pantera)

        btnaudio6.setOnClickListener{


            mediaPlayer2?.start()
        }


var btn8 = findViewById<Button>(R.id.button8)

        btn8.setOnClickListener{
            startActivity(Intent(this,MainActivity3::class.java))


        }

    }
}