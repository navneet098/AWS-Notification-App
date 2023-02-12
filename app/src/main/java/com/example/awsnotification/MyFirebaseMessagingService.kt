package com.example.awsnotification

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.firebase.messaging.ktx.remoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        Looper.prepare()
        Handler().post{
            Toast.makeText(baseContext, message.notification?.title,Toast.LENGTH_LONG).show()
        }
        Looper.loop()
        super.onMessageReceived(message)
    }
}