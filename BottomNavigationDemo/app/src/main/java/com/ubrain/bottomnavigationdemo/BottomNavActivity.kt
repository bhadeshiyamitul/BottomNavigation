package com.ubrain.bottomnavigationdemo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.RelativeLayout
import android.widget.TextView

class BottomNavActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mMessage.setText(R.string.title_guide)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard1 -> {
                mMessage.setText(R.string.title_news)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private lateinit var mContainer: RelativeLayout
    private lateinit var mNavigation: BottomNavigationView
    private lateinit var mMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)


        mContainer = findViewById<RelativeLayout>(R.id.container)
        mNavigation = findViewById<BottomNavigationView>(R.id.navigation)
        mMessage = findViewById<TextView>(R.id.message)

        mNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
