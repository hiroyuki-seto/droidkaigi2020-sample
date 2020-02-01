package com.setoh.sample.shadow

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.RectF
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.shape.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ShapeAppearanceModel.Builder()
            .setAllCornerSizes(RelativeCornerSize(0.2f))
            .setAllCorners(object : CornerTreatment() {
                private val bounds = RectF()
                override fun getCornerPath(
                    shapePath: ShapePath,
                    angle: Float,
                    interpolation: Float,
                    radius: Float
                ) {
                    shapePath.reset(0f, radius, 180f, 180 - angle)
                    shapePath.lineTo(radius, radius)
                    shapePath.lineTo(radius, 0f)
                }
            })
            .build()

        val elevation = resources.getDimension(R.dimen.view_elevation)
        val speechBalloonBackground1 = MaterialShapeDrawable(model).apply {
            fillColor = ColorStateList.valueOf(Color.WHITE)
            this.elevation = elevation
        }
        findViewById<View>(R.id.shadow1).background = speechBalloonBackground1

        val model2 = ShapeAppearanceModel.Builder()
            .setTopEdge(object : EdgeTreatment() {
                override fun getEdgePath(
                    length: Float,
                    center: Float,
                    interpolation: Float,
                    shapePath: ShapePath
                ) {
                    shapePath.lineTo(length / 3, 0f)
                    shapePath.lineTo(length / 3, length / 3)
                    shapePath.lineTo(length * 2 / 3, length / 3)
                    shapePath.lineTo(length * 2 / 3, 0f)
                    shapePath.lineTo(length, 0f)
                }
            })
            .build()
        val speechBalloonBackground2 = MaterialShapeDrawable(model2).apply {
            fillColor = ColorStateList.valueOf(Color.WHITE)
            this.elevation = elevation
        }
        findViewById<View>(R.id.shadow2).background = speechBalloonBackground2
    }
}
