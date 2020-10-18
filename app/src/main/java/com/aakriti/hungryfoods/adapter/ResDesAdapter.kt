package com.aakriti.hungryfoods.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.model.ResDesModel

class ResDesAdapter(private val foodItemList:ArrayList<ResDesModel>):RecyclerView.Adapter<ResDesAdapter.ResDesViewHolder>(){
    class ResDesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgFoodImage: ImageView = view.findViewById(R.id.imgFoodItem)
        var txtFoodItemName: TextView = view.findViewById(R.id.txtFoodItemName)
        var txtFoodItemCost: TextView = view.findViewById(R.id.txtFoodItemCost)
        var txtFoodItemDiscount: TextView = view.findViewById(R.id.txtFoodItemDiscount)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResDesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.res_des_single_row,parent,false)
        return ResDesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return foodItemList.size
    }
    override fun onBindViewHolder(holder: ResDesViewHolder, position: Int)
    {           val model =foodItemList[position]
        holder.txtFoodItemCost.text = model.fItemCost
        holder.txtFoodItemName.text = model.fItemName
        holder.txtFoodItemDiscount.text = model.fItemDiscount
        holder.imgFoodImage.setImageResource(model.fItemImg)
        /*holder.itemView.setOnClickListener {
            val intent= Intent(context, ResDesActivity::class.java)
            intent.putExtra("res_id",model.resId)
            context.startActivity(intent)
        }*/
    }
}
