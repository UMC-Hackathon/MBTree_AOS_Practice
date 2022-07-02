package com.umc.project.mbtree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.umc.project.mbtree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivMainTree.bringToFront()

        binding.touchView.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                var curX: Float = p1!!.x
                var curY: Float = p1.y!!

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
                        var fruit: ImageView = ImageView(this@MainActivity)
                        fruit.setImageResource(R.drawable.ic_fruit)
                        fruit.maxWidth = 20
                        fruit.maxHeight = 20
                        fruit.x = curX
                        fruit.y = curY
                        binding.mainLayout.addView(fruit)
                    }
                }
                return true
            }
        })
    }
}