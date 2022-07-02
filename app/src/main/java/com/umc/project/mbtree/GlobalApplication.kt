package com.umc.project.mbtree

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // SDK를 사용하기 위해서 네이티브 앱 키로 초기화
        KakaoSdk.init(this, "b9cb5b66529d307feb9e07fb2553d715")
    }
}