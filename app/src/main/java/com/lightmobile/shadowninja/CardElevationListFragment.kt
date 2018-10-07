package com.lightmobile.shadowninja

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_card.view.card

class CardElevationListFragment : Fragment() {

    val args by lazy {
        CardElevationListFragmentArgs.fromBundle(arguments)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return RecyclerView(requireContext()).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            layoutManager = GridLayoutManager(requireContext(), args.columns)
            adapter = object : Adapter<ViewHolder>() {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = object : ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
                ) {
                    init {
                        itemView.card.cardElevation = args.elevation.toFloat()
                    }
                }

                override fun getItemCount() = 55529

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
            }
        }
    }
}
