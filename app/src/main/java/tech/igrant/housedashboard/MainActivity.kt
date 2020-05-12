package tech.igrant.housedashboard

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : Activity() {

    private val handler: Handler = Handler()

    lateinit var mainText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainText = findViewById(R.id.main_text)
        target()

        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    @SuppressLint("SetTextI18n")
    private fun target() {
        handler.postDelayed(
            {
                val date = Date()
                SimpleDateFormat("yyyy-MM-dd HH:MM:ss").apply {
                    mainText.text = this.format(date)
                }
                target()
            },
            1000
        )
    }

}