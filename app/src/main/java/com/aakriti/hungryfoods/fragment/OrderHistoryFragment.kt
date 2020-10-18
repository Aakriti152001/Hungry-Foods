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
import com.aakriti.hungryfoods.adapter.HomeAdapter
import com.aakriti.hungryfoods.adapter.OrderHistoryAdapter
import com.aakriti.hungryfoods.model.OrderHistoryModel
import com.aakriti.hungryfoods.model.RestaurantModel

class OrderHistoryFragment : Fragment() {
    lateinit var recyclerViewOrderHistory: RecyclerView
    lateinit var orderHistoryAdapter: OrderHistoryAdapter
    private var resOrderList = arrayListOf(
        OrderHistoryModel(R.drawable.wowmomo,"Wow Momo"," Industrial Area 1,Chandigarh","ORDERED ON : 20 Dec,2019 at 20:40 pm","ITEMS : 3 X Onion Pizza","TOTAL AMOUNT : Rs. 550.47"),
        OrderHistoryModel(R.drawable.toshib,"Toshib","Shop No-07 A,Sector 34C,Chandigarh","ORDERED ON : 2 Jan,2020 at 15:34 pm","ITEMS : 1 X Chicken Biryani","TOTAL AMOUNT : Rs. 230.01"),
        OrderHistoryModel(R.drawable.wowmomo,"Wow Momo","Industrial Area 2,Chandigarh","ORDERED ON : 1 March,2020 at 13:12 pm","ITEMS : 2 X Momo (Large Plate)","TOTAL AMOUNT : Rs. 197.18"),
        OrderHistoryModel(R.drawable.bell_taco,"Taco Bell","SCO No. 453, 35C Market Rd,Chandigarh","ORDERED ON : 13 Oct,2019 at 22:37 pm","ITEMS : 5 X Crunchwrap Supreme","TOTAL AMOUNT : Rs. 1110.00")
       )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_order_history, container, false)
        recyclerViewOrderHistory = view.findViewById(R.id.recyclerViewOrderHistoryXml)
        orderHistoryAdapter= OrderHistoryAdapter(activity as Context,resOrderList)
        recyclerViewOrderHistory.adapter=orderHistoryAdapter
        recyclerViewOrderHistory.layoutManager = LinearLayoutManager(context)
        return view
    }
}