package com.example.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    var drawerLayout: DrawerLayout = findViewById(R.id.navView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(
            this@MainActivity, drawerLayout, R.string.open ,R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //functionality for the nav drawer items
        val navView: NavigationView = findViewById(R.id.navView)
        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.home -> {
                    replaceFragment(HomeFragment(), it.title.toString())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragTrans = fragmentManager.beginTransaction()
        fragTrans.replace(R.id.frameLay1, fragment)
        fragTrans.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }
}