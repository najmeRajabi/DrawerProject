package com.example.drawerproject

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_main)



        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(
            setOf( R.id.homeFragment, R.id.profileFragment, R.id.settingFragment,R.id.nav_exit ),
            drawerLayout )
        toolbar.setupWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)
        setSupportActionBar(toolbar)

//        navView.menu.findItem(R.id.nav_exit).setOnMenuItemClickListener { finishAffinity()}
        
//        navView.getHeaderView(R.id.txv_nameD)

       navView.setNavigationItemSelectedListener {
           when (it.itemId){
               R.id.nav_exit -> {
                   finish()
                   true
               }
           }
           NavigationUI.onNavDestinationSelected(it, navController)
           drawerLayout.closeDrawer(GravityCompat.START)
           true
       }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.home_menu, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun getTheme(): Resources.Theme {
        val theme = super.getTheme()
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("HW10_theme" , Context.MODE_PRIVATE)
        when (sharedPreferences.getString(THEME,"blue")) {
            "blue" -> {
                theme.applyStyle(R.style.Theme_DrawerProject, true)
//                Utils.changeToTheme(this, Utils.THEME_DEFAULT)
            }
            "pink" -> {
                theme.applyStyle(R.style.Theme_Pink, true)
            }
            "dark" -> {
                theme.applyStyle(R.style.Theme_DrawerProject_dark, true)
            }
        }
        return theme
    }



}

