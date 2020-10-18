package com.aakriti.hungryfoods.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.model.CoronaPreModel
import com.aakriti.hungryfoods.model.QnaModel

class CoronaPreAdapter(val context: Context, private val itemList:ArrayList<CoronaPreModel>):
    RecyclerView.Adapter<CoronaPreAdapter.CoronaPreViewHolder>(){
    class CoronaPreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgCoronaPre: ImageView = view.findViewById(R.id.imgCoronaPreXml)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaPreViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_corona_pre_single_row,parent,false)
        return CoronaPreViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: CoronaPreViewHolder, position: Int)
    {           val model =itemList[position]
        holder.imgCoronaPre.setImageResource(model.imgCoPre)
    }
}