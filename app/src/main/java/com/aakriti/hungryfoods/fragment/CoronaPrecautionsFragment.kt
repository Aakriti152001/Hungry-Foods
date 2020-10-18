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
import com.aakriti.hungryfoods.adapter.CoronaPreAdapter
import com.aakriti.hungryfoods.model.CoronaPreModel

class CoronaPrecautions : Fragment() {
lateinit var recyclerCoronaPre:RecyclerView
    lateinit var coronaPreAdapter: CoronaPreAdapter
    private val coPreList= arrayListOf(
        CoronaPreModel(R.drawable.copr1),
        CoronaPreModel(R.drawable.copr2),
        CoronaPreModel(R.drawable.copr3),
        CoronaPreModel(R.drawable.copr4),
        CoronaPreModel(R.drawable.copr5)
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_corona_precautions, container, false)
        recyclerCoronaPre=view.findViewById(R.id.recyclerViewCoronaPrecautionsXml)
        coronaPreAdapter= CoronaPreAdapter(activity as Context,coPreList)
        recyclerCoronaPre.adapter=coronaPreAdapter
        recyclerCoronaPre.layoutManager=LinearLayoutManager(context)
        return view
    }
    /*
    recyclerViewHome = view.findViewById(R.id.recyclerViewHomeXml)
        homeAdapter= HomeAdapter(activity as Context,displayList)
        recyclerViewHome.adapter=homeAdapter
        recyclerViewHome.layoutManager = LinearLayoutManager(context)
     */
}