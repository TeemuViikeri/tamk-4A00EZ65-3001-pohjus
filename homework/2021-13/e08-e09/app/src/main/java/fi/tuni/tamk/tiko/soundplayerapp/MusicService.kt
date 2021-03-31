package fi.tuni.tamk.tiko.soundplayerapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicService: Service(), MediaPlayer.OnPreparedListener {

    private var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mediaPlayer = MediaPlayer()
        mediaPlayer?.apply {
            val uri: String = intent.getStringExtra("uri").toString()
            setDataSource(uri)
            isLooping = false
            setOnPreparedListener(this@MusicService)
            prepareAsync()
        }

        return START_STICKY
    }

    override fun onPrepared(mp: MediaPlayer?) {
        mp?.start()
        mp?.setOnCompletionListener {
            Intent().also {
                it.action = "fi.tuni.tamk.COMPLETED"
                sendBroadcast(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

