package com.aakriti.hungryfoods.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.activity.ResDesActivity
import com.aakriti.hungryfoods.model.FavResModel


class FavAdapter(val context: Context, private val itemList:ArrayList<FavResModel>):
    RecyclerView.Adapter<FavAdapter.FavViewHolder>() {
    class FavViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var favRestaurantName: TextView = view.findViewById(R.id.txtFavResName)
        var favResCost: TextView = view.findViewById(R.id.txtFavResCost)
        var favResRating: TextView = view.findViewById(R.id.txtFavResRating)
        var favResImage: ImageView = view.findViewById(R.id.imgFavResImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_fav_res_single_row, parent, false)
        return FavViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        val model = itemList[position]
        holder.favResCost.text = model.favResCost
        holder.favRestaurantName.text = model.favResName
        holder.favResRating.text = model.favResRating
        holder.favResImage.setImageResource(model.favResImage)

        holder.itemView.setOnClickListener {
            val intent= Intent(context, ResDesActivity::class.java)
            intent.putExtra("res_id",model.favResId)
            context.startActivity(intent)
        }
    }
}