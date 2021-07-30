package com.ubrain.bottomnavigation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ubrain.bottomnavigation.R
import com.ubrain.bottomnavigation.fragment.BottomNavFragment
import com.ubrain.bottomnavigation.utils.DummyContent
import kotlinx.android.synthetic.main.fragment_bottom_nav_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 *
 */
class BottomNavItemAdapter(
    private val mValues: List<DummyContent.DummyItem>,
    private val mListener: BottomNavFragment.OnListFragmentInteractionListener?,
    private val myTheme: Int
) : RecyclerView.Adapter<BottomNavItemAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyContent.DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_bottom_nav_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        // holder.mIdView.text = item.id
        //  holder.mContentView.text = item.content

        if (myTheme == 1) {
            holder.mCardItem.setCardBackgroundColor(Color.parseColor("#121212"))
            holder.mContentView.setTextColor(Color.WHITE)
        } else {
            holder.mCardItem.setCardBackgroundColor(Color.WHITE)
            holder.mContentView.setTextColor(Color.BLACK)
        }
        holder.mCardItem.radius = 10f
        holder.mCardItem.cardElevation = 2f

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) :
        RecyclerView.ViewHolder(mView) {
        // val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        val mCardItem: androidx.cardview.widget.CardView = mView.card_item

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
