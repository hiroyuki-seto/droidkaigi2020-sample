package com.setoh.sample.droidkaigi2020

import com.google.android.material.shape.EdgeTreatment
import com.google.android.material.shape.ShapePath

class SpeechBalloonBottomEdgeTreatment(
    private val arrowRight: Float,
    private val arrowHeight: Float
) : EdgeTreatment() {

    override fun getEdgePath(
        length: Float,
        center: Float,
        interpolation: Float,
        shapePath: ShapePath
    ) {
        shapePath.lineTo(arrowRight, 0f)
        shapePath.lineTo(arrowRight, -arrowHeight)
        shapePath.lineTo(arrowRight + arrowHeight, 0f)
        shapePath.lineTo(length, 0f)
    }
}