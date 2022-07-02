package com.umc.project.mbtree

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "b9cb5b66529d307feb9e07fb2553d715")
    }
}