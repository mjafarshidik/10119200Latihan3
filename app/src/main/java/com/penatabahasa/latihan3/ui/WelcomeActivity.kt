package com.penatabahasa.latihan3.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.penatabahasa.latihan3.IntentID.ID_EXTRA_MSG_EXIT
import com.penatabahasa.latihan3.databinding.ActivityWelcomeBinding

/*
26 April 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intentToLoginCode()
        allActivityFinish()
    }

    private fun allActivityFinish() {
        if (intent.getBooleanExtra(ID_EXTRA_MSG_EXIT, false)) {
            finish()
        }
    }

    private fun intentToLoginCode() {
        binding.apply {
            btnWalkthroughStart.setOnClickListener {
                val intent = Intent(this@WelcomeActivity, LoginCodeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}