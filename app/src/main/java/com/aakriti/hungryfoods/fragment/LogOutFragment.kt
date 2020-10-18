package com.aakriti.hungryfoods.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.aakriti.hungryfoods.R

class LogOutFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_log_out, container, false)
        val dialog= AlertDialog.Builder(activity as Context)
        dialog.setTitle("Confirm Exit!!..")
        dialog.setIcon(R.drawable.ic_logout)
        dialog.setMessage("Do you want to exit?")
        dialog.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
            ActivityCompat.finishAffinity(activity as Activity)
        }
        dialog.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> }
        dialog.show()

        return view
    }

}