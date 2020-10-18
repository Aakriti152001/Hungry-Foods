package com.aakriti.hungryfoods.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.model.OrderHistoryModel
import com.aakriti.hungryfoods.model.RestaurantModel

class OrderHistoryAdapter(val context: Context, private val itemList:ArrayList<OrderHistoryModel>):
    RecyclerView.Adapter<OrderHistoryAdapter.OderHistoryViewHolder>(){
    class OderHistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var orderHisRestaurantImage: ImageView = view.findViewById(R.id.imgOHisResImage)
        var orderHisRestaurantName: TextView = view.findViewById(R.id.txtOHisResName)
        var orderHisRestaurantLocation: TextView = view.findViewById(R.id.txtOHisResLocation)
        var orderHisResDate: TextView = view.findViewById(R.id.txtOHisResOderDate)
        var orderHisResItems: TextView = view.findViewById(R.id.txtOHisResItems)
        var orderHisResTotalAmount: TextView = view.findViewById(R.id.txtOHisResTotalAmount)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OderHistoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_order_history_single_row,parent,false)
        return OderHistoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: OderHistoryViewHolder, position: Int)
    {           val model =itemList[position]
        holder.orderHisRestaurantImage.setImageResource(model.oHisResImage)
        holder.orderHisRestaurantName.text = model.oHisResName
        holder.orderHisRestaurantLocation.text = model.oHisResLocation
        holder.orderHisResDate.text = model.oHisResDate
        holder.orderHisResItems.text = model.oHisResItems
        holder.orderHisResTotalAmount.text = model.oHisResTotalAmount

    }
}