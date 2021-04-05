package fi.tuni.tamk.tiko.lottoapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlin.concurrent.thread


class LottoService : Service() {
    private var isRunning = false

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d("numbers", "in lotto service")
        var numbers = intent.getIntArrayExtra("numbers")!!.toSortedSet()

        thread {
            isRunning = true
            var weeks = 0

            while (isRunning) {
                Thread.sleep(20)

                weeks++

                val randoms = (1..40).shuffled().take(7).toSortedSet()
                val same = numbers.intersect(randoms)

                val manager = LocalBroadcastManager.getInstance(this)
                val i = Intent("highlight")
                i.putExtra("randoms", randoms.toIntArray())
                manager.sendBroadcast(i)

                if (same.size == 7) {
                    isRunning = false

                    val years: Double = (weeks * 1.0 / 52)
                    val text = "Took %.2f years".format(years)
                    Log.d("numbers", text)
                    stopSelf()
                }
            }
        }

        return START_STICKY
    }
}