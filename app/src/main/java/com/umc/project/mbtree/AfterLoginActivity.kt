package com.umc.project.mbtree

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.kakao.sdk.user.UserApiClient

class AfterLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)

        val profileNickname = findViewById<TextView>(R.id.profile_nickname) // 로그인 버튼

        val profileImage = findViewById<ImageView>(R.id.profile_image) // 프로필 이미지뷰


        UserApiClient.instance.me { user, error ->
            profileNickname.text = "닉네임: ${user?.kakaoAccount?.profile?.nickname}"


            // 유저 프로필 사진 url 받아오기
            val profileImageUrl = user?.kakaoAccount?.profile?.thumbnailImageUrl

            Glide.with(this)
                .load(profileImageUrl) // 불러올 이미지 url
                .fallback(R.drawable.gift) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
                .into(profileImage) // 이미지를 넣을 뷰
        }




        val kakao_logout_button = findViewById<Button>(R.id.kakao_logout_button) // 로그인 버튼

        kakao_logout_button.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Toast.makeText(this, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        val kakao_unlink_button = findViewById<Button>(R.id.kakao_unlink_button) // 로그인 버튼

        kakao_unlink_button.setOnClickListener {
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Toast.makeText(this, "회원 탈퇴 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "회원 탈퇴 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                    finish()
                }
            }
        }
    }

}
