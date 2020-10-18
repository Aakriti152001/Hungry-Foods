package com.aakriti.hungryfoods.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.aakriti.hungryfoods.R
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var etName: EditText
    lateinit var etEmailId: EditText
    lateinit var etMobileNumber: EditText
    lateinit var etDeliveryAddress: EditText
    lateinit var etPassword: EditText
    lateinit var etConfirmPassword: EditText
    lateinit var btnRegister: Button
    lateinit var toolbar: Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_now)
        auth = FirebaseAuth.getInstance()

        etName = findViewById(R.id.etName)
        etEmailId = findViewById(R.id.etEmailId)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etDeliveryAddress = findViewById(R.id.etDeliveryAddress)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)
        toolbar=findViewById(R.id.toolbar)

        setUpToolBar()

        btnRegister.setOnClickListener {

            registerUser()
        }
    }

    private fun registerUser()
    {
        when
        {
            TextUtils.isEmpty(etName.text.toString()) -> etName.error = "Please enter your name"

            (etName.text.toString().length <= 4) -> etName.error = "Name too short "

            TextUtils.isEmpty(etEmailId.text.toString()) -> etEmailId.error = "Please enter mail"

            (!Patterns.EMAIL_ADDRESS.matcher(etEmailId.text.toString()).matches()) -> etEmailId.error = "Please enter valid mail"

            TextUtils.isEmpty(etMobileNumber.text.toString()) -> etMobileNumber.error = "Please enter mobile number"

            (etMobileNumber.text.toString().length<10)-> etMobileNumber.error = "Mobile number not appropriate"

            TextUtils.isEmpty(etDeliveryAddress.text.toString()) -> etDeliveryAddress.error = "Please enter DeliveryAddress"

            TextUtils.isEmpty(etPassword.text.toString()) -> etPassword.error = "Please enter password"

            (etPassword.text.toString().length < 6) -> etPassword.error = "Password too short "

            TextUtils.isEmpty(etConfirmPassword.text.toString()) -> etConfirmPassword.error = "Please enter confirm Password"

            (etPassword.text.toString() != etConfirmPassword.text.toString()) -> etConfirmPassword.error = "Passwords don't match"

            else ->
            {
                auth.createUserWithEmailAndPassword(etEmailId.text.toString(), etPassword.text.toString()).addOnCompleteListener(this)

                { task ->
                    if (task.isSuccessful) {

                        val user = auth.currentUser
                        user?.sendEmailVerification()?.addOnCompleteListener{ task ->
                            if (task.isSuccessful) {
                                Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this@RegistrationActivity,LoginActivity::class.java))
                                finish()
                            }
                        }


                    } else {
                        Toast.makeText(baseContext, "Oops!! Something went wrong..", Toast.LENGTH_SHORT).show()}
                }
            }
        }
    }
    private fun setUpToolBar(){
         setSupportActionBar(toolbar)
         supportActionBar?.title="Register"
         supportActionBar?.setHomeButtonEnabled(true)
         supportActionBar?.setDisplayHomeAsUpEnabled(true) }

//try try but never give up
    override fun onSupportNavigateUp(): Boolean {
            startActivity(Intent(this,LoginActivity::class.java))
        return true
    }
}


