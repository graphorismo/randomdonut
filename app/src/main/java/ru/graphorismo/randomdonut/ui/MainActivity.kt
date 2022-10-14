package ru.graphorismo.randomdonut.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import ru.graphorismo.randomdonut.R
import ru.graphorismo.randomdonut.data.repository.DonutRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        findViewById<ImageView>(R.id.imageView)
            .setImageResource(R.drawable.ic_baseline_cookie_24)
        findViewById<TextView>(R.id.textView)
            .setText(R.string.placeholder)
        findViewById<Button>(R.id.button)
            .setOnClickListener(){
                this.lifecycleScope.launch {

                    try {
                        val response = DonutRepository.getInstance().getRandomDonut()
                        Log.d("DONUT", "Response received: $response")
                    } catch (ex: Exception) {
                        Snackbar.make(it,"Cant get network respond. ${ex.message}", Snackbar.LENGTH_LONG)
                            .show()

                    }
                }
            }

    }
}