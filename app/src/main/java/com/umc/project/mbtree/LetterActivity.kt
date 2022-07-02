package com.umc.project.mbtree

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.umc.project.mbtree.databinding.ActivityLetterBinding

class LetterActivity: Activity() {

    lateinit var binding: ActivityLetterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLetterBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        Log.d("LetterAcitivity", "Letter넘어옴")
        binding.btnOk.setOnClickListener{
            val intent = Intent(baseContext, MainActivity::class.java)
            intent.putExtra("content", binding.etPost.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        binding.btnCancel.setOnClickListener{
            val intent = Intent(baseContext, MainActivity::class.java)
            setResult(RESULT_CANCELED, intent)
            finish()
        }

    }

}