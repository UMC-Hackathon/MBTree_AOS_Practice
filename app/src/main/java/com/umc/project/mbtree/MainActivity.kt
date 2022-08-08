package com.umc.project.mbtree

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.umc.project.mbtree.api.RetrofitInterface
import com.umc.project.mbtree.api.getRetrofit
import com.umc.project.mbtree.databinding.ActivityMainBinding
import com.umc.project.mbtree.dto.Post
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var TAG: String = "MainActivity"
    lateinit var binding: ActivityMainBinding

    private lateinit var getResult: ActivityResultLauncher<Intent>
    private var curX:Float = 0.0F
    private var curY:Float = 0.0F
    // PR연습

    val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
            if(result.resultCode == Activity.RESULT_OK){
                val data:Intent? = result.data
                val content = data?.getStringExtra("content").toString()
                Log.d(TAG, "적은 내용: " + content)

                var fruit: ImageView = ImageView(this@MainActivity)
                fruit.setImageResource(R.drawable.ic_letter)
                fruit.maxWidth = 10
                fruit.maxHeight = 10
                fruit.x = curX
                fruit.y = curY
                binding.mainLayout.addView(fruit)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivMainTree.bringToFront()

        Log.d("레트로핏 테스트", "레트로핏 연결")
        getPosts()

        //나무에 열매달기
        binding.touchView.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                curX = p1!!.x
                curY = p1.y!!

                when(p1.action){
                    //터치가 처음 눌렸을 때
                    MotionEvent.ACTION_DOWN->{
                        Toast.makeText(applicationContext, "누름", Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "x좌표: " + curX)
                        Log.d(TAG, "y좌표" + curY)
                    }
                    MotionEvent.ACTION_UP->{
                        Toast.makeText(applicationContext, "손 뗌", Toast.LENGTH_SHORT).show()
                        Log.d(TAG, "마지막 x좌표: " + curX)
                        Log.d(TAG, "마지막 y좌표" + curY)

                        val intent = Intent(application, LetterActivity::class.java)
                        resultLauncher.launch(intent)
                    }
                }
                return true
            }
        })
    }

    private fun getPosts(){
        //test: 1번 유저 인덱스 요청
        val service = getRetrofit().create(RetrofitInterface::class.java)
//        Log.d("레트로핏 테스트", service.get)
        service.getPosts(1)
            .enqueue(object: retrofit2.Callback<List<Post>>{
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                    Log.d("레트로핏 테스트", "성공")
                    val pList: List<Post> = response.body()!!
                    Log.d("레트로핏 테스트", pList.toString())
                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    Log.d("레트로핏 테스트", "실패")
                    Log.d("레트로핏 테스트", t.message.toString())
                }

            })
    }
}