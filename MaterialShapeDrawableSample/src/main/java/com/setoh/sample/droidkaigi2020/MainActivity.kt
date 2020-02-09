package com.setoh.sample.droidkaigi2020

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.google.android.material.shape.AbsoluteCornerSize
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val cornerSize = resources.getDimension(R.dimen.speech_balloon_corner_size)
        val arrowHeight = resources.getDimension(R.dimen.speech_balloon_arrow_height)
        val arrowRight = resources.getDimension(R.dimen.speech_balloon_arrow_right)
        val model = ShapeAppearanceModel.Builder()
            .setAllCornerSizes(AbsoluteCornerSize(cornerSize))
            .setBottomEdge(SpeechBalloonBottomEdgeTreatment(arrowHeight, arrowRight))
            .build()

        val elevation = resources.getDimension(R.dimen.speech_balloon_elevation)
        val padding = resources.getDimensionPixelSize(R.dimen.speech_balloon_padding)
        val speechBalloonBackground1 = MaterialShapeDrawable(model).apply {
            fillColor = ColorStateList.valueOf(Color.WHITE)
            this.elevation = elevation
            setPadding(padding, padding, padding, padding)
        }
        findViewById<View>(R.id.speech_balloon1).background = speechBalloonBackground1

        val model2 = ShapeAppearanceModel.Builder(model)
            .build()
        val speechBalloonBackground2 = MaterialShapeDrawable(model2).apply {
            fillColor = ColorStateList.valueOf(Color.WHITE)
            this.elevation = elevation
            setPadding(padding, padding, padding, padding)
        }
        val inset = resources.getDimensionPixelSize(R.dimen.speech_balloon_inset)
        val insetBackground = InsetDrawable(speechBalloonBackground2, inset)
        findViewById<View>(R.id.speech_balloon2).background = insetBackground
    }

}
