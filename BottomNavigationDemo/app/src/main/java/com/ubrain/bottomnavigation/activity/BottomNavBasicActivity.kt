package com.ubrain.bottomnavigation.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ubrain.bottomnavigation.R
import com.ubrain.bottomnavigation.fragment.BottomNavFragment
import com.ubrain.bottomnavigation.utils.DummyContent

class BottomNavBasicActivity : AppCompatActivity(), BottomNavFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }

   /* override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return if (item?.itemId == android.R.id.home){
            onBackPressed()
            true
        } else {
            item?.let {
                super.onOptionsItemSelected(it)
            } ?: kotlin.run {
                false
            }
        }
    }*/

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                setBottomNavFrg(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                setBottomNavFrg(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                setBottomNavFrg(2)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard1 -> {
                textMessage.setText(R.string.title_dashboard)
                setBottomNavFrg(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications1 -> {
                textMessage.setText(R.string.title_notifications)
                setBottomNavFrg(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.getIntExtra(ARG_MY_INDEX, 0) == 3) {
            ARG_MY_THEME = 1
            setTheme(R.style.MyDarkTheme)
        } else {
            ARG_MY_THEME = 0
            setTheme(R.style.AppTheme)
        }
        setContentView(R.layout.activity_bottom_nav_basic)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        textMessage = findViewById(R.id.message)

        preset(navView, fab)
    }

    @SuppressLint("WrongConstant")
    private fun preset(navView: BottomNavigationView, fab: FloatingActionButton) {
        hideFab(navView, fab)
        setBottomNavFrg(0)
        fab.setOnClickListener {
            setBottomNavFrg(1)
        }
        navView.apply {
            when (intent.getIntExtra(ARG_MY_INDEX, 0)) {
                1 -> {
                    menu.clear()
                    inflateMenu(R.menu.bottom_nav_menu_5)
                    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_AUTO
                    itemTextColor = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                    itemIconTintList = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                }
                2 -> {
                    menu.clear()
                    inflateMenu(R.menu.bottom_nav_menu)
                    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_AUTO
                    itemTextColor = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item_different)
                    itemIconTintList = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item_different)
                }
                3 -> {
                    menu.clear()
                    inflateMenu(R.menu.bottom_nav_menu)
                    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_AUTO
                    itemTextColor = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item_different)
                    itemIconTintList = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item_different)
                }
                4 -> {
                    menu.clear()
                    inflateMenu(R.menu.bottom_nav_menu)
                    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
                    itemTextColor = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                    itemIconTintList = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                }
                5 -> {
                    fab.show()
                    navView.setBackgroundColor(Color.WHITE)
                    menu.clear()
                    inflateMenu(R.menu.bottom_nav_menu_fab)
                    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_AUTO
                    itemTextColor = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                    itemIconTintList = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                }
                6 -> {
                    menu.clear()
                    inflateMenu(R.menu.bottom_nav_menu)
                    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
                    itemTextColor = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item_different)
                    itemIconTintList = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item_different)
                }
                else -> {
                    menu.clear()
                    inflateMenu(R.menu.bottom_nav_menu)
                    labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_AUTO
                    itemTextColor = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                    itemIconTintList = ContextCompat.getColorStateList(this@BottomNavBasicActivity,
                            R.color.color_bottom_nav_item)
                }
            }
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }
    }

    private fun setBottomNavFrg(mTab: Int) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame_bottom_nav_basic, BottomNavFragment.newInstance(mTab, ARG_MY_THEME))
                .commit()
    }

    private fun hideFab(navView: BottomNavigationView, fab: FloatingActionButton) {
        fab.hide()
        val a = TypedValue()
        theme.resolveAttribute(android.R.attr.windowBackground, a, true)
        if (a.type >= TypedValue.TYPE_FIRST_COLOR_INT && a.type <= TypedValue.TYPE_LAST_COLOR_INT) {
            // windowBackground is a color
            val color = a.data
            navView.setBackgroundColor(color)
        } else {
            // windowBackground is not a color, probably a drawable
        }
    }

    companion object {

        private const val ARG_MY_INDEX = "my_index"
        private var ARG_MY_THEME = 0

        fun newInstance(context: Context, myIndex: Int): Intent {
            return Intent(context, BottomNavBasicActivity::class.java).apply {
                putExtra(ARG_MY_INDEX, myIndex)
            }
        }
    }
}
