package com.aakriti.hungryfoods.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.activity.ResDesActivity
import com.aakriti.hungryfoods.model.RestaurantModel

class HomeAdapter(val context: Context,private val resNameList:ArrayList<RestaurantModel>):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){
    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtRestaurantName: TextView = view.findViewById(R.id.txtRestaurantName)
        var txtCost: TextView = view.findViewById(R.id.txtCost)
        var txtResRating: TextView = view.findViewById(R.id.txtResRating)
        var imgResImage: ImageView = view.findViewById(R.id.imgRestaurant)
        var favResIcon:ImageView=view.findViewById(R.id.imgFavResIcon)
        var resTiming:TextView=view.findViewById(R.id.txtTiming)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_home_single_row,parent,false)
        return HomeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return resNameList.size
    }
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int)
    {           val model =resNameList[position]
        holder.txtCost.text = model.resCost
        holder.txtRestaurantName.text = model.resName
        holder.txtResRating.text = model.resRating
        holder.resTiming.text=model.resTiming
        holder.imgResImage.setImageResource(model.resImage)
        holder.favResIcon.setImageResource(model.fvResIcon)
        holder.itemView.setOnClickListener {
          val intent=Intent(context,ResDesActivity::class.java)
            intent.putExtra("res_id",model.resId)
            context.startActivity(intent)
        }
    }
}
