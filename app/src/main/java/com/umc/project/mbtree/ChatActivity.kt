package com.umc.project.mbtree

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.umc.project.mbtree.databinding.ActivityChatBinding

class ChatActivity: AppCompatActivity() {

    lateinit var binding: ActivityChatBinding
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityChatBinding.inflate(layoutInflater)

        binding.ibSend.setOnClickListener{

        }
        //firebase객체 가져오기
        firebaseAnalytics = Firebase.analytics
        //이벤트 로깅
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM){
            param(FirebaseAnalytics.Param.ITEM_ID, 1)
            param(FirebaseAnalytics.Param.ITEM_NAME, "user1")
            param(FirebaseAnalytics.Param.CONTENT_TYPE, "")
        }

    }
}