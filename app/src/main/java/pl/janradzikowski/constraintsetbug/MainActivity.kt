package pl.janradzikowski.constraintsetbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import pl.janradzikowski.constraintsetbug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vb.showContent.setOnClickListener { showContent() }
        vb.showSplash.setOnClickListener { showSplash() }
    }

    private fun showSplash() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(vb.rootView)
        constraintSet.setVerticalBias(R.id.logo, 0.5f)
        constraintSet.setVisibility(R.id.contentGroup, View.GONE)
        constraintSet.setVisibility(R.id.splashScreen, View.VISIBLE)
        constraintSet.applyTo(vb.rootView)
    }

    private fun showContent() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(vb.rootView)
        constraintSet.setVerticalBias(R.id.logo, 0.3f)
        constraintSet.setVisibility(R.id.contentGroup, View.VISIBLE)
        constraintSet.setVisibility(R.id.splashScreen, View.GONE)
        constraintSet.applyTo(vb.rootView)
    }
}