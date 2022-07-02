package com.umc.project.mbtree

import android.app.Dialog
import android.content.Context
import android.view.WindowManager

class LetterDialog(context: Context) {
    private val dialog = Dialog(context)

    fun showDialog(){
        dialog.setContentView(R.layout.activity_letter)
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()
    }

//    private lateinit var onClickListener: ButtonClickListener
//
//    fun setOnClickListener(listener: ButtonClickListener){
//        onClickListener = listener
//    }
}