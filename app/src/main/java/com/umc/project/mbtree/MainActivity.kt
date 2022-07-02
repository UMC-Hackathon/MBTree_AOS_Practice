package com.umc.project.mbtree

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun onClick(view: View) { val dialogFragment: DialogFragment = GPSDialogFragment()
        when (view.id) {
            R.id.button1 -> //                다이얼로그 표시, 프래그먼트를 사용하므로 FragmentManager 를 전달
                dialogFragment.show(supportFragmentManager, "gps dilog")
        }
    }


}