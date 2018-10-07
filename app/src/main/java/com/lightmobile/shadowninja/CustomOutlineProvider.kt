package com.lightmobile.shadowninja

import android.graphics.Outline
import android.graphics.Rect
import android.view.View
import android.view.ViewOutlineProvider

class CustomOutlineProvider(
    var radius: Float,
    var scaleX: Float,
    var scaleY: Float,
    var xOffset: Int,
    var yOffset: Int,
    var isOval: Boolean = false
) : ViewOutlineProvider() {

    private val rect = Rect()

    override fun getOutline(view: View, outline: Outline) {
        view.background.copyBounds(rect)
        rect.offset(xOffset, yOffset)
        rect.scaleX(scaleX)
        rect.scaleY(scaleY)
        if (isOval) {
            outline.setOval(rect)
        } else {
            outline.setRoundRect(rect, radius)
        }
    }

    private fun Rect.scaleX(scaleX: Float) {
        val toAdd = (width() - (width() * scaleX)) / 2
        set((left + toAdd).toInt(), top, (right - toAdd).toInt(), bottom)
    }

    private fun Rect.scaleY(scaleY: Float) {
        val toAdd = (height() - (height() * scaleY)) / 2
        set(left, (top + toAdd).toInt(), right, (bottom - toAdd).toInt())
    }
}
