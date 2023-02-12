package com.example.awsnotification

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.awsnotification.databinding.ActivityMainBinding
import com.google.android.gms.tasks.*
import com.google.firebase.messaging.FirebaseMessaging


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val token=FirebaseMessaging.getInstance().token
        println("Hello $token")

//        binding.button.setOnClickListener {view->
//            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task->
//                if(!task.isSuccessful){
//                    return@OnCompleteListener
//                }
//
//                val token=task.result
//
//                Toast.makeText(baseContext,token,Toast.LENGTH_LONG).show()
//
//
//                var clipboardManager=getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                val clipData=ClipData.newPlainText("text",token)
//                clipboardManager.setPrimaryClip(clipData)
//
//            })
//
//        }

        FirebaseMessaging.getInstance().token.addOnSuccessListener { token: String ->
            if (!TextUtils.isEmpty(token)) {
                Log.d(TAG, "retrieve token successful : $token")
            } else {
                Log.w(TAG, "token should not be null...")
            }
        }.addOnFailureListener { e: Exception? -> }.addOnCanceledListener {}
            .addOnCompleteListener { task: Task<String> ->
                Log.v(
                    TAG,
                    "This is the token : " + task.result
                )
            }


    }
}

//cLaJeB5-Q8ijkKo0MlrKMY:APA91bEC9Zy2cCJjY6-Sjs9wGKeMoSKVsXVRiULEyyxL0tdzK4-GYNNO5YSRRRGSWTDBu1uA1QYJYL75y8WT2bFUhEVNP1yuAehtJ__X0vxxIzeDkXARQe5Clf3aM7UE61tj-Dzzvqn6