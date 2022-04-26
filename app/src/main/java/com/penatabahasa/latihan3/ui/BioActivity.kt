package com.penatabahasa.latihan3.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.penatabahasa.latihan3.IntentID.ID_EXTRA_MSG
import com.penatabahasa.latihan3.R
import com.penatabahasa.latihan3.data.User
import com.penatabahasa.latihan3.databinding.ActivityBioBinding
import kotlinx.android.synthetic.main.activity_warning_dialog.view.*

/*
26 April 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class BioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentToDone()
    }

    private fun intentToDone() {
        binding.apply {
            btnBiodataNext.setOnClickListener {
                val dataName = edtBiodataName.text.toString()
                val dataAge = edtBiodataAge.text.toString()
                if (dataAge.isEmpty()) {
                    Toast.makeText(
                        this@BioActivity,
                        R.string.age_empty,
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val age = dataAge.toInt()
                    val user = User(dataName, age)
                    if (dataName == "") {
                        showWarningMessage()
                    } else {
                        val intent = Intent(this@BioActivity, DoneActivity::class.java)
                        intent.putExtra(ID_EXTRA_MSG, user)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun showWarningMessage() {
        val view = View.inflate(this@BioActivity, R.layout.activity_warning_dialog, null)
        val builder = AlertDialog.Builder(this@BioActivity)
        builder.setView(view)
        val dialog = builder.create()

        view.txtWarningDialogTitle.text = getString(R.string.check_code_warning_empty_title_name)
        view.txtWarningDialogDesc.text = getString(R.string.check_code_warning_empty_desc_name)

        dialog.setCancelable(false)
        dialog.show()

        view.btnWarningDialogOk.setOnClickListener { dialog.dismiss() }
    }
}