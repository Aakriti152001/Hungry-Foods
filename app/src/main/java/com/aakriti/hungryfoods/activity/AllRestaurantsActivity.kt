package com.aakriti.hungryfoods.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.aakriti.hungryfoods.R
import com.aakriti.hungryfoods.fragment.*
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class AllRestaurantsActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var navigationView: NavigationView
    var previousMenuItem:MenuItem?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_restaurants)
        auth = FirebaseAuth.getInstance()
        drawerLayout=findViewById(R.id.drawerLayout)
        toolbar=findViewById(R.id.toolbar)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        navigationView=findViewById(R.id.navigationView)

        setUpToolBar()
        openHome()
        //displaying  the hamburger icon on the home button of the action bar
        val actionBarDrawerToggle=ActionBarDrawerToggle(this@AllRestaurantsActivity, drawerLayout, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        //enabling the the different fragments on the menu drawer to listen to the click
        navigationView.setNavigationItemSelectedListener {
            if(previousMenuItem!=null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it
            when(it.itemId){
                R.id.home ->{
                  openHome()
                }
                R.id.myProflie ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,MyProfileFragment()).commit()
                    supportActionBar?.title="My Profile"
                    drawerLayout.closeDrawers()}
                R.id.favouriteRestaurants ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,FavouriteRestaurantsFragment()).commit()
                    supportActionBar?.title="Favourite Restaurants"
                    drawerLayout.closeDrawers()}
                R.id.orderHistory ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,OrderHistoryFragment()).commit()
                    supportActionBar?.title="Order History"
                    drawerLayout.closeDrawers()}
                R.id.coronaPrecautions->{
                    supportFragmentManager.beginTransaction().replace(R.id.frameLayout,CoronaPrecautions()).commit()
                    supportActionBar?.title="Corona Precautions"
                    drawerLayout.closeDrawers()}
                R.id.qna ->{
                  supportFragmentManager.beginTransaction().replace(R.id.frameLayout,FaqsFragment()).commit()
                    supportActionBar?.title="FAQs"
                    drawerLayout.closeDrawers()}
                R.id.logOut ->{
                    val dialog= AlertDialog.Builder(this)
                    dialog.setTitle("Confirm Exit!!..")
                    dialog.setIcon(R.drawable.ic_logout)
                    dialog.setMessage("Do you want to exit?")
                    dialog.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
                        auth.signOut()
                        startActivity(Intent(this,LoginActivity::class.java))
                    }
                    dialog.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> }
                    dialog.show()

                  }
            }
            return@setNavigationItemSelectedListener true
        }
    }

    //setup toolbar as an action bar
    private fun setUpToolBar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="ToolBar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationView.setCheckedItem(R.id.home)
    }

    //opening the drawer layout to open from the left
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    //setting home fragment as the default screen to be displayed when the user successfully logins
    private fun openHome(){
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,HomeFragment()).commit()
        drawerLayout.closeDrawers()
        supportActionBar?.title="Indian Restaurants"
    }

    override fun onBackPressed() {
        when(supportFragmentManager.findFragmentById(R.id.frameLayout)){
            else->ActivityCompat.finishAffinity(this)
            //super.onBackPressed()
        }
    }
}