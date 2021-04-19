package com.liyanamarket.predictlive.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.utils.CheckValidateInputNumber
import kotlinx.android.synthetic.main.activity_number.*
import kotlinx.android.synthetic.main.activity_recovery.*

class RecoveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)
        btn_next_recoveryactivity.setOnClickListener {


            if (CheckValidateInputNumber(this).validatenumber(edt_phonenumber_recoveryactivity.text.toString())) {
                Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
            }
        }
    }
}