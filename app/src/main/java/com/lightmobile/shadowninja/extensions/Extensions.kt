package com.lightmobile.shadowninja.extensions

import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener

fun SeekBar.setListener(listener: (Int) -> Unit) = setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        listener(progress)
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
})
