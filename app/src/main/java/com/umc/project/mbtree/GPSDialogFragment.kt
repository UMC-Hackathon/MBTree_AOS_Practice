package com.umc.project.mbtree

import android.app.Application
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class GPSDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        다이얼로그 생성 및 반환
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setMessage("위치 정보 이용, 동네 인증, 위치 등록?")
            .setCancelable(false)
            .setPositiveButton(
                "확인"
            ) { dialogInterface, i ->
                val intent= Intent(this.requireContext(), LocationActivity::class.java)
                startActivity(intent)
            }.setNegativeButton("취소",null);
        return builder.create()
    }
}