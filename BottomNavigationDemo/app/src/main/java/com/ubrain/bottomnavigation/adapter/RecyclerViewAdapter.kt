package com.ubrain.bottomnavigation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.ubrain.bottomnavigation.R

class RecyclerViewAdapter(
    private var context: Context,
    private var imgCardList: java.util.ArrayList<String>
) : RecyclerView.Adapter<RecyclerViewAdapter.Tempo>() {

    private var onClickListener: OnClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tempo {
        return Tempo(
            LayoutInflater.from(context).inflate(
                R.layout.adapter_recyclerview_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return imgCardList.size
    }

    override fun onBindViewHolder(holder: Tempo, position: Int) {
        holder.apply {
            mTitle.text = imgCardList[position]

            itemView.setOnClickListener {onClickListener?.onClick(position) }
        }
    }

    class Tempo(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTitle = itemView.findViewById<TextView>(R.id.title)
    }

    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }
    interface OnClickListener{
        fun onClick(position:Int)
    }
}