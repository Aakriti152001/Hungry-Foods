package com.aakriti.hungryfoods.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.adapter.ResDesAdapter
import com.aakriti.hungryfoods.model.ResDesModel

class ResDesActivity : AppCompatActivity() {
    lateinit var resDesToolbar: Toolbar
    lateinit var resDesRecyclerView:RecyclerView
    lateinit var resDesAdapter: ResDesAdapter
    var fItemArray1= arrayListOf(
        ResDesModel(R.drawable.kfc1,"4 Pc Hot Wings + Pepsi + Fries","Rs.189 X 1","25 % OFF"),
        ResDesModel(R.drawable.kfc2,"Smoky Grilled Bucket (3 Leg Pieces)","Rs.199 X 2 ","30 % OFF"),
        ResDesModel(R.drawable.kfc3,"Mega Chicken Burger","Rs.229 X 2 ","10 % OFF"),
        ResDesModel(R.drawable.kfc4,"The Double Down ","Rs.199 X 1","37 % OFF"),
        ResDesModel(R.drawable.kfc5,"The Ultimate Bucket (10 Leg Pieces + Pepsi + 2 Dips) ","Rs.679 X 1","47 % OFF")
    )
    var fItemArray2= arrayListOf(
        ResDesModel(R.drawable.pizza1,"Chicken Slice Pizza","Rs.109 X 1","31 % OFF"),
        ResDesModel(R.drawable.pizza2,"Mini Corn Pizza (Extra Cheese)","Rs.179 X 1 ","40 % OFF"),
        ResDesModel(R.drawable.pizza3,"Oregano Pizza","Rs.229 X 1 ","27 % OFF"),
        ResDesModel(R.drawable.pizza4,"Paneer Pizza","Rs.99 X 1","30 % OFF"),
        ResDesModel(R.drawable.pizza5,"The Supreme Box ( Corn Pizza + Capsicum Pizza + 4 X Pepsi) ","Rs.559 X 1","42 % OFF")
    )
    var resId:String?="27"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res_des)
        resDesToolbar=findViewById(R.id.resDesToolbar)
        resDesRecyclerView=findViewById(R.id.resDesRecyclerViewXml)
        setUpToolBar()
        if(intent!=null){
            resId=intent.getStringExtra("res_id")
        }
        if(resId=="1")
        {
            supportActionBar?.title="KFC"
            resDesAdapter= ResDesAdapter(fItemArray1)
            resDesRecyclerView.adapter=resDesAdapter
            resDesRecyclerView.layoutManager=LinearLayoutManager(this)
        }
        else if(resId=="2")
        {
                supportActionBar?.title="Pizza Hut"
                resDesAdapter= ResDesAdapter(fItemArray2)
                resDesRecyclerView.adapter=resDesAdapter
                resDesRecyclerView.layoutManager=LinearLayoutManager(this)

        }
    }
    private fun setUpToolBar(){
        setSupportActionBar(resDesToolbar)
        supportActionBar?.title="ToolBar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this,AllRestaurantsActivity::class.java))
        return true
    }
}