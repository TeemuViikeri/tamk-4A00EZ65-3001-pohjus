package fi.tuni.tamk.tiko

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Time changed", Toast.LENGTH_SHORT).show()
        Log.d("MyBroadCastReceiver", "Time changed")
    }
}