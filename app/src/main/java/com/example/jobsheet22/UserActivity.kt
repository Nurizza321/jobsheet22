package com.example.jobsheet22

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.se.omapi.Session
import android.widget.Button
import android.widget.TextView
import kotlin.math.log

class UserActivity : AppCompatActivity() {

    private lateinit var logoutBtn: Button
    private lateinit var nama_lengkap: TextView
    private lateinit var sessionManager: com.example.jobsheet22.Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sessionManager = com.example.jobsheet22.Session(this)

        logoutBtn = findViewById(R.id.btnLogout)
        nama_lengkap = findViewById(R.id.textNama)

        if (!sessionManager.isLoggedIn()) {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            nama_lengkap.text = sessionManager.getUser()
        }

        logoutBtn.setOnClickListener {
            val session = sessionManager.logout()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}