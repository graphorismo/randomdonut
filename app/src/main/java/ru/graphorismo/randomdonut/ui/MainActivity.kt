package ru.graphorismo.randomdonut.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.graphorismo.randomdonut.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ImageView>(R.id.imageView)
            .setImageResource(R.drawable.ic_baseline_cookie_24)
        findViewById<TextView>(R.id.textView)
            .setText(R.string.placeholder)

    }
}