package com.lightmobile.shadowninja

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lightmobile.shadowninja.extensions.setListener
import kotlinx.android.synthetic.main.fragment_outline.button
import kotlinx.android.synthetic.main.fragment_outline.circleOutlineCheck
import kotlinx.android.synthetic.main.fragment_outline.elevationBar
import kotlinx.android.synthetic.main.fragment_outline.offsetXSeekBar
import kotlinx.android.synthetic.main.fragment_outline.offsetYSeekBar
import kotlinx.android.synthetic.main.fragment_outline.scaleXBar
import kotlinx.android.synthetic.main.fragment_outline.scaleYBar

class OutlineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_outline, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val cornerRadius = resources.getDimension(R.dimen.corner_radius)
        val outlineProvider = CustomOutlineProvider(cornerRadius, 1f, 1f, 0, 0)
        button.outlineProvider = outlineProvider

        button.elevation = elevationBar.progress.toFloat()
        elevationBar.setListener { button.elevation = it.toFloat() }
        scaleXBar.setListener {
            outlineProvider.scaleX = it.div(100f)
            button.invalidateOutline()
        }
        scaleYBar.setListener {
            outlineProvider.scaleY = it.div(100f)
            button.invalidateOutline()
        }
        offsetXSeekBar.setListener {
            outlineProvider.xOffset = it
            button.invalidateOutline()
        }
        offsetYSeekBar.setListener {
            outlineProvider.yOffset = it
            button.invalidateOutline()
        }
        circleOutlineCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            outlineProvider.isOval = isChecked
            button.invalidateOutline()
        }
    }
}
