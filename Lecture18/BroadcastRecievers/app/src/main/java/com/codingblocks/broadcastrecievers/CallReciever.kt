package com.codingblocks.broadcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CallReciever : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context,"Broadcasrt Recieved",Toast.LENGTH_LONG).show()

        when(intent.action){
            Intent.ACTION_NEW_OUTGOING_CALL ->{
                Toast.makeText(context,"Broadcasrt Recieved",Toast.LENGTH_LONG).show()
            }
        }
    }
}
