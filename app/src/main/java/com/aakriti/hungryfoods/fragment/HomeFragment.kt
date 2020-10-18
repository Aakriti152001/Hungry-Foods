package com.aakriti.hungryfoods.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.adapter.HomeAdapter
import com.aakriti.hungryfoods.model.RestaurantModel
import java.util.*


class HomeFragment : Fragment() {

    lateinit var recyclerViewHome: RecyclerView
    lateinit var homeAdapter: HomeAdapter
    var ratingComparator = Comparator<RestaurantModel> { res1, res2 ->
        if (res1.resRating.compareTo(res2.resRating, true) == 0) {
            res1.resName.compareTo(res2.resName, true)
        } else {
            res1.resRating.compareTo(res2.resRating, true)
        }
    }
    private val displayList = arrayListOf<RestaurantModel>()
   /* private var resList = arrayListOf(
        RestaurantModel(
            "1",
            "SCO 425 to 426",
            R.drawable.kfc,
            "KFC",
            "3.8",
            R.drawable.ic_favorite_restaurants,
            "34 mins"
        ),
        RestaurantModel(
            "2",
            "N 82,Shopping Plaza",
            R.drawable.pizzaahut,
            "Pizza Hut",
            "4.1",
            R.drawable.ic_favorite_restaurants,
            "28 mins"
        ),
        RestaurantModel(
            "3",
            "Elante Mall",
            R.drawable.mac_d,
            "MacDonald",
            "3.9",
            R.drawable.ic_favorite_restaurant,
            "45 mins"
        ),
        RestaurantModel(
            "4",
            "Shop-16,Food Court Phase 1",
            R.drawable.burger_king,
            "BurgerKing",
            "4.5",
            R.drawable.ic_favorite_restaurant,
            "29 mins"
        ),
        RestaurantModel(
            "5",
            "Elante Mall",
            R.drawable.domino,
            "Domino's",
            "4.3",
            R.drawable.ic_favorite_restaurant,
            "30 mins"
        ),
        RestaurantModel(
            "6",
            "SCO No. 453 & 454,35 Market",
            R.drawable.bell_taco,
            "Taco Bell",
            "4.1",
            R.drawable.ic_favorite_restaurant,
            "40 mins"
        ),
        RestaurantModel(
            "7",
            "Shop No.-37,Phase 11,Mohali",
            R.drawable.wowmomo,
            "Wow Momo",
            "4.9",
            R.drawable.ic_favorite_restaurants,
            "57 mins"
        ),
        RestaurantModel(
            "8",
            "Sop no-07 A,Sec-34 C",
            R.drawable.toshib,
            "Toshib",
            "3.7",
            R.drawable.ic_favorite_restaurant,
            "44 mins"
        ),
        RestaurantModel(
            "9",
            "Phase 6, Mohali",
            R.drawable.thangabali,
            "Thangabali",
            "4.3",
            R.drawable.ic_favorite_restaurants,
            "53 mins"
        ),
        RestaurantModel(
            "10",
            "Sec-22,Chandigarh",
            R.drawable.desiaroma,
            "Desi Aroma",
            "4.8",
            R.drawable.ic_favorite_restaurant,
            "25 mins"
        )
    )*/

   /* private var resList = arrayListOf(
        RestaurantModel("1", "SCO 1A", R.drawable.it1, "Courtyard", "3.8",R.drawable.ic_favorite_restaurant,"37 mins"),
        RestaurantModel("2", "Hyatt Regency,Chandigarh", R.drawable.it2, "Piccante", "4.1",R.drawable.ic_favorite_restaurant,"29 mins"),
        RestaurantModel("3", "Booth No. 10, Inner Road,Sec-30A", R.drawable.it3, "La Pino'z Pizza", "3.9",R.drawable.ic_favorite_restaurant,"40 mins"),
        RestaurantModel("4", "Sec-16D,Chandigarh", R.drawable.it4, "BurgerKing", "4.5",R.drawable.ic_favorite_restaurant,"39 mins"),
        RestaurantModel("5", "Chanidgarh", R.drawable.it5, "The Hedgehog Cafe", "4.3",R.drawable.ic_favorite_restaurant,"50 mins"),
        RestaurantModel("6", "SCO 190,191 Madhya Marg ", R.drawable.it6, "Caffe Tonino", "4.1",R.drawable.ic_favorite_restaurant,"42 mins")
            )*/
    private var resList = arrayListOf(
        RestaurantModel("1", "SCO 1A", R.drawable.in1, "Sundarams South Indain Food", "4.8",R.drawable.ic_favorite_restaurant,"37 mins"),
        RestaurantModel("2", "Hyatt Regency,Chandigarh", R.drawable.in4, "Foodies", "3.7",R.drawable.ic_favorite_restaurant,"29 mins"),
        RestaurantModel("3", "Booth No. 10, Inner Road,Sec-30A", R.drawable.in5, "Dastaan", "4.0",R.drawable.ic_favorite_restaurant,"40 mins"),
        RestaurantModel("4", "178 Hyatt Regency", R.drawable.in2, "Urban Cafe", "3.5",R.drawable.ic_favorite_restaurant,"39 mins"),
        RestaurantModel("5", "NS-1934 near DS College,SEC-41 C", R.drawable.in3, "The Hedgehog Cafe", "4.0",R.drawable.ic_favorite_restaurant,"50 mins"),
        RestaurantModel("6", "SCO- 260", R.drawable.in6, "Punjabi Dhaba", "4.4",R.drawable.ic_favorite_restaurant,"42 mins")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)
        displayList.addAll(resList)
        recyclerViewHome = view.findViewById(R.id.recyclerViewHomeXml)
        homeAdapter = HomeAdapter(activity as Context, displayList)
        recyclerViewHome.adapter = homeAdapter
        recyclerViewHome.layoutManager = LinearLayoutManager(context)
        return view
    }
}
/*
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_bar, menu)
        val menuItem2 = menu.findItem(R.id.sortRating)
        val menuItem1 = menu.findItem(R.id.search)
        if (menuItem1 != null) {
            val searchView = menuItem1.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        resList.forEach {
                            if (it.resName.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                        recyclerViewHome.adapter!!.notifyDataSetChanged()
                    } else {
                        displayList.clear()
                        displayList.addAll(resList)
                        recyclerViewHome.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }

            })
        }
       if (menuItem2 != null) {
            Collections.sort(displayList, ratingComparator)
            displayList.reverse()
            homeAdapter.notifyDataSetChanged()
        }
    }
}*/

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id==R.id.sortRating)
        {
            Collections.sort(displayList,ratingComparator)
            displayList.reverse()
        }
        homeAdapter.notifyDataSetChanged()
        return super.onOptionsItemSelected(item)
    }
    }*/

       /* val menuItem= menu.findItem(R.id.search)
        val searchView=menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
                return super.onCreateOptionsMenu(menu, inflater)
    }*/


  /*  override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }*/

/*
if(menuItem!=null){

            searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if(newText!!.isNotEmpty()){
                     displayList.clear()
                        val search =newText.toLowerCase(Locale.getDefault())
                        resList.forEach{
                            if(it.resName.toLowerCase(Locale.getDefault()).contains(search)){
                                displayList.add(it)
                            }
                        }
                        recyclerViewHome.adapter!!.notifyDataSetChanged()
                    }
                    else{
                        displayList.clear()
                        displayList.addAll(resList)
                        recyclerViewHome.adapter!!.notifyDataSetChanged()
                    }
                   return true
                }

            })
        }*/





