package com.aakriti.hungryfoods.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import com.aakriti.hungryfoods.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.aakriti.hungryfoods.util.ConnectionManager

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegisterNow: TextView
    lateinit var etEmailId: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegisterNow = findViewById(R.id.txtRegisterNow)
        etEmailId = findViewById(R.id.etEmailId)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)



         auth = FirebaseAuth.getInstance()
        if(ConnectionManager().checkConnectivity(this)) {
            btnLogin.setOnClickListener {

                doLogin()
            }

            txtForgotPassword.setOnClickListener {
                startActivity(Intent(this, ForgotPasswordActivity::class.java))
            }

            txtRegisterNow.setOnClickListener {
                val intent = Intent(this, RegistrationActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        else{
            val dialog= AlertDialog.Builder(this)
            dialog.setTitle("Error")
            dialog.setMessage("Internet Connection Not Found")
            dialog.setPositiveButton("Open Settings"){text,listener->
                val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                finish()
            }
            dialog.setNegativeButton("Exit the App"){text,listener->
                ActivityCompat.finishAffinity(this)
            }
            dialog.create()
            dialog.show()
        }
    }

    private fun doLogin() {

        when {
            (etEmailId.text.toString().isEmpty()) -> etEmailId.error = "Please enter mail"

            (!Patterns.EMAIL_ADDRESS.matcher(etEmailId.text.toString())
                .matches()) -> etEmailId.error = "Please enter valid mail"

            (etPassword.text.toString().isEmpty()) -> etPassword.error = "Please enter password"

            (etPassword.text.toString().length < 6) -> etPassword.error = "Password too short"

            else -> {

                auth.signInWithEmailAndPassword(
                    etEmailId.text.toString(),
                    etPassword.text.toString()
                ).addOnCompleteListener(this)
                { task ->
                    if (task.isSuccessful)
                    {
                            val user = auth.currentUser
                            updateUI(user)
                        }
                        else
                        {
                            Toast.makeText(this, "Error!! - No such user found!!", Toast.LENGTH_SHORT).show()
                            Toast.makeText(this, "Kindly Register Yourself", Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }

private fun updateUI(currentUser:FirebaseUser?)
{
    if(currentUser!=null){
        if(currentUser.isEmailVerified){
            startActivity(Intent(this,AllRestaurantsActivity::class.java))}
        else{
            Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show()}
    }

}
    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
}




