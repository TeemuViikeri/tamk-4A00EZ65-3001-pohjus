package fi.tuni.tamk.tiko

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class MyBackgroundService : Service() {

    private var isRunning: Boolean = false

    // We are not using binded service, service can only be started and stopped
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyBackgroundService", "service started")
        isRunning = true
        thread {
            var i = 1
            while (isRunning) {
                Log.d("TAG", Thread.currentThread().name)
                Thread.sleep(1000)
                sendBroadcast(Intent("fi.tuni.tamk.test").putExtra("value", i.toString()))
                i++
            }
        }

        // If service is killed by android, it will try to start it again when
        // possible
        return START_STICKY
    }

    override fun onDestroy() {
        isRunning = false
        super.onDestroy()
        Log.d("MyBackgroundService", "service stopped")
    }
}