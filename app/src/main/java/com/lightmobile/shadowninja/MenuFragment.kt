package com.lightmobile.shadowninja

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lightmobile.shadowninja.R.string
import kotlinx.android.synthetic.main.fragment_menu.cardElevationListButton
import kotlinx.android.synthetic.main.fragment_menu.columnsBar
import kotlinx.android.synthetic.main.fragment_menu.columnsLabel
import kotlinx.android.synthetic.main.fragment_menu.elevationBar
import kotlinx.android.synthetic.main.fragment_menu.elevationLabel
import kotlinx.android.synthetic.main.fragment_menu.elevationListButton
import kotlinx.android.synthetic.main.fragment_menu.elevationOutlineButton
import kotlinx.android.synthetic.main.fragment_menu.imageListButton
import kotlinx.android.synthetic.main.fragment_menu.menuOverviewButton

class MenuFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_menu, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        menuOverviewButton.setOnClickListener { findNavController().navigate(MenuFragmentDirections.toOverview()) }
        imageListButton.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.toImageList()
                    .setColumns(columnsBar.progress)
            )
        }
        elevationListButton.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.toElevationList()
                    .setColumns(columnsBar.progress)
                    .setElevation(elevationBar.progress)
            )
        }
        cardElevationListButton.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.toCardElevationList()
                    .setColumns(columnsBar.progress)
                    .setElevation(elevationBar.progress)
            )
        }
        elevationOutlineButton.setOnClickListener { findNavController().navigate(MenuFragmentDirections.toOutline()) }

        setElevationLabel(elevationBar.progress)
        elevationBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                setElevationLabel(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        setColumnsLabel(columnsBar.progress)
        columnsBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                setColumnsLabel(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun setColumnsLabel(progress: Int) {
        columnsLabel.setText(getString(string.menu_list_columns_label, progress))
    }

    private fun setElevationLabel(progress: Int) {
        elevationLabel.setText(getString(string.menu_elevation_bar_label, progress))
    }
}
