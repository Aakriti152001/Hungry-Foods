package com.aakriti.hungryfoods.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.model.QnaModel
import com.aakriti.hungryfoods.model.RestaurantModel

class QnaAdapter(val context: Context, private val itemList:ArrayList<QnaModel>):
    RecyclerView.Adapter<QnaAdapter.QnaViewHolder>(){
    class QnaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var txtQues: TextView = view.findViewById(R.id.txtQues)
        var txtAns: TextView = view.findViewById(R.id.txtAns)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QnaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_qna_single_row,parent,false)
        return QnaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: QnaViewHolder, position: Int)
    {           val model =itemList[position]
        holder.txtQues.text = model.resQues.toString()
        holder.txtAns.text = model.resAns.toString()
    }
}