package com.ubrain.bottomnavigation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ubrain.bottomnavigation.R
import com.ubrain.bottomnavigation.adapter.BottomNavItemAdapter
import com.ubrain.bottomnavigation.utils.DummyContent

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [BottomNavFragment.OnListFragmentInteractionListener] interface.
 */
class BottomNavFragment : androidx.fragment.app.Fragment() {

    private var bottomNavTabIndex = 0
    private var myTheme = 0

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            bottomNavTabIndex = it.getInt(ARG_TAB_INDEX)
            myTheme = it.getInt(ARG_MY_THEME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_nav, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(
                    context,
                    if (bottomNavTabIndex == 1) LinearLayoutManager.HORIZONTAL else LinearLayoutManager.VERTICAL,
                    false
                )

                if (bottomNavTabIndex == 1) {
                    layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    val marginLayoutParams = ViewGroup.MarginLayoutParams(view.getLayoutParams())
                    marginLayoutParams.setMargins(0, 16, 0, 16)
                    layoutParams = marginLayoutParams
                } else {
                    layoutManager = LinearLayoutManager(
                        context,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    val marginLayoutParams = ViewGroup.MarginLayoutParams(view.getLayoutParams())
                    marginLayoutParams.setMargins(16, 0, 16, 0)
                    layoutParams = marginLayoutParams
                }

                adapter = BottomNavItemAdapter(DummyContent.ITEMS, listener, myTheme)
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: DummyContent.DummyItem?)
    }

    companion object {

        const val ARG_TAB_INDEX = "tab_index"
        const val ARG_MY_THEME = "my_theme"

        @JvmStatic
        fun newInstance(bottomNavTabIndex: Int, arG_MY_THEME: Int) =
            BottomNavFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TAB_INDEX, bottomNavTabIndex)
                    putInt(ARG_MY_THEME, arG_MY_THEME)
                }
            }
    }
}
