package com.penatabahasa.latihan3.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.penatabahasa.latihan3.R
import com.penatabahasa.latihan3.databinding.ActivityLoginCodeBinding
import kotlinx.android.synthetic.main.activity_warning_dialog.view.*

/*
26 April 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class LoginCodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        covertStringTagHTML()
        intentToBio()
    }

    private fun covertStringTagHTML() {
        binding.apply {
            val htmlText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(
                    getString(R.string.check_code_text_agreement),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            } else {
                @Suppress("DEPRECATION")
                Html.fromHtml(getString(R.string.check_code_text_agreement))
            }
            txtCheckCodeAgree.text = htmlText
        }
    }

    private fun intentToBio() {
        binding.apply {
            btnCheckCode.setOnClickListener {
                val code = edtInputCode.text.toString()
                if (code == "") {
                    showWarningMessage()
                } else {
                    startActivity(Intent(this@LoginCodeActivity, BioActivity::class.java))
                }
            }
        }
    }

    private fun showWarningMessage() {
        val view = View.inflate(this@LoginCodeActivity, R.layout.activity_warning_dialog, null)
        val builder = AlertDialog.Builder(this@LoginCodeActivity)
        builder.setView(view)
        val dialog = builder.create()

        view.txtWarningDialogTitle.text = getString(R.string.check_code_warning_empty_title)
        view.txtWarningDialogDesc.text = getString(R.string.check_code_warning_empty_desc)

        dialog.setCancelable(false)
        dialog.show()

        view.btnWarningDialogOk.setOnClickListener { dialog.dismiss() }
    }
}