package com.aakriti.hungryfoods.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.aakriti.hungryfoods.R
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var btnNext: Button
    lateinit var etEmail:EditText
    lateinit var toolbarForgotPassword: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        toolbarForgotPassword=findViewById(R.id.toolbarForgotPassword)

        setUpToolBar()
        setSupportActionBar(toolbarForgotPassword)
        supportActionBar?.title="Forgot Password"

        btnNext=findViewById(R.id.btnNext)
        etEmail=findViewById(R.id.etEmailId)
        auth=FirebaseAuth.getInstance()
        btnNext.setOnClickListener {
            val email=etEmail.text.toString()
            if(email.isEmpty()){
                etEmail.error = "Enter email"
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                etEmail.error = "Enter valid mail"
            }
            forgotPassword(email)
        }
    }
    private fun forgotPassword(email:String){

        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Reset Password Email sent", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@ForgotPasswordActivity,LoginActivity::class.java))
                }
            }

    }
    private fun setUpToolBar(){
        setSupportActionBar(toolbarForgotPassword)
        supportActionBar?.title="Forgot Password"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) }

    //try try but never give up
    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this,LoginActivity::class.java))
        return true
    }
}