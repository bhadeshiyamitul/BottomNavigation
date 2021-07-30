package com.ubrain.bottomnavigation.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.ubrain.bottomnavigation.R
import com.ubrain.bottomnavigation.adapter.RecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    private var context:Context?=null
    private var recyclerView: RecyclerView?=null
    private var recyclerViewAdapter:RecyclerViewAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        init()
    }

    private fun init() {
        recyclerView = findViewById(R.id.recyclerView)

        recyclerViewAdapter = context?.let { RecyclerViewAdapter(it,arrList) }
        recyclerView?.adapter= recyclerViewAdapter

        recyclerViewAdapter?.setOnClickListener(object :RecyclerViewAdapter.OnClickListener{
            override fun onClick(position: Int) {
                startActivity(context?.let { BottomNavBasicActivity.newInstance(it, position) })
            }
        })
    }

    private val arrList: ArrayList<String>
        get() {
            return ArrayList<String>().apply {
                add(getString(R.string.basic))
                add(getString(R.string.shifting))
                add(getString(R.string.light))
                add(getString(R.string.dark))
                add(getString(R.string.icon))
                add(getString(R.string.primary))
                add(getString(R.string.light_simple))
            }
        }
}