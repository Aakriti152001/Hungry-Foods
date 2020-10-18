package com.aakriti.hungryfoods.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.adapter.FavAdapter
import com.aakriti.hungryfoods.adapter.HomeAdapter
import com.aakriti.hungryfoods.model.FavResModel
import com.aakriti.hungryfoods.model.RestaurantModel

class FavouriteRestaurantsFragment : Fragment() {
    lateinit var recyclerViewFavRes: RecyclerView
    lateinit var favResAdapter: FavAdapter
    private var favResList = arrayListOf(
        FavResModel("1","SCO 425 to 426",R.drawable.kfc,"KFC","3.8"),
        FavResModel("2","N-82,Shopping Plaza",R.drawable.pizzaahut,"Pizza Hut","4.1"),
        FavResModel("3","Shop No.-37,Phase 11,Mohali",R.drawable.wowmomo,"Wow Momo","4.9"),
        FavResModel("4","Phase 6, Mohali",R.drawable.thangabali,"Thangabali","4.3"),
        FavResModel("5","Sec-22,Chandigarh",R.drawable.desiaroma,"Desi Aroma","4.8")
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_favourite_restaurants, container, false)
        recyclerViewFavRes = view.findViewById(R.id.recyclerFavourite)
        favResAdapter= FavAdapter(activity as Context,favResList)
        recyclerViewFavRes.adapter=favResAdapter
        recyclerViewFavRes.layoutManager = GridLayoutManager(context,2)
        return view
    }

}