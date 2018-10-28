package com.lightmobile.shadowninja

import android.os.Bundle
import android.os.Trace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.android.synthetic.main.item_shadow_image.view.card
import java.util.Random

class ImageListFragment : Fragment() {

    private val args by lazy {
        ImageListFragmentArgs.fromBundle(arguments)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val random = Random()
        return RecyclerView(requireContext()).apply {
            layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
            layoutManager = GridLayoutManager(requireContext(), args.columns)
            recycledViewPool.setMaxRecycledViews(0, 13 * args.columns)
            adapter = object : Adapter<ViewHolder>() {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = object : ViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_shadow_image, parent, false)
                ) {
                    init {
                        val margin = random.nextInt(100)
                        (itemView.card.layoutParams as ConstraintLayout.LayoutParams).setMargins(margin, margin, margin, margin)
                    }
                }

                override fun getItemCount() = 55529

                override fun onBindViewHolder(holder: ViewHolder, position: Int) {}
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Trace.beginSection("Suspicious function")
        Thread.sleep(1000)
        Trace.endSection()
    }
}
