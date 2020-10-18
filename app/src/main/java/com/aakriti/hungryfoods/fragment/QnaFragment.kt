package com.aakriti.hungryfoods.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.adapter.QnaAdapter
import com.aakriti.hungryfoods.model.QnaModel

class FaqsFragment : Fragment() {
lateinit var recyclerViewQna:RecyclerView
    lateinit var qnaAdapter:QnaAdapter
    val qnaList= arrayListOf<QnaModel>(
        QnaModel("Q1. Is Hungry Foods Safe according to security purpose ?",
            "Ans. Yes, Hungry Foods uses Firebase authentication which only allows verified user to use the application"),
        QnaModel("Q2. I do not remember my password ?" ,
            "Ans. Click on Log out from the navigation drawer. Then click on Forgot Password? Fill out your mail address and a password recovery will be sent to you by mail.ion which only allows verified user to use the application"),
        QnaModel("Q3. What are your delivery hours?", "Ans. Our delivery hour are 24 X 7."),
        QnaModel("Q4. Can I place order on call? ","Ans. Sorry, we don’t accept orders on call."),
        QnaModel("Q5. Why is my location is not serviceable? ",
            "Ans. We are currently live only in a few cities. We will be expanding soon."),
        QnaModel("Q6. How Hungry Foods ensures user's safety in this pandemic ? ",
            "Ans. You can check the Corona Precautions from the Navigation drawer that are being taken by the Hungry Foods to ensure customer's safety"),
        QnaModel("Q7. How to sign up as a new customer? ",
            "Ans. You can go the singup /register option from the Login Page itself."),
                QnaModel("Q8. Where will be the verification link shred after registeration ? ",
        "Ans. The registration verification link will appear in your provided email. Kindly click on the link given to verify your mail.")

        )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_qna, container, false)
        recyclerViewQna=view.findViewById(R.id.recyclerViewQnAXml)
        qnaAdapter= QnaAdapter(activity as Context,qnaList)
        recyclerViewQna.adapter=qnaAdapter
        recyclerViewQna.layoutManager=LinearLayoutManager(context)
        return view
    }

}