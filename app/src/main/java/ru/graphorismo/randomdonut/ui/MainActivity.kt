package ru.graphorismo.randomdonut.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import ru.graphorismo.randomdonut.R
import ru.graphorismo.randomdonut.data.repository.DonutRepository
import ru.graphorismo.randomdonut.ui.stateholders.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        findViewById<ImageView>(R.id.imageView)
            .setImageResource(R.drawable.ic_baseline_cookie_24)
        textView = findViewById<TextView>(R.id.textView)
        textView.setText(R.string.placeholder)
        findViewById<Button>(R.id.button)
            .setOnClickListener(){
                viewModel.updateDonutData()
            }

        viewModel.donutData.observe(this){
            if( it != null){
                textView.setText("${it.name}\n${it.description}")
            }
        }

    }
}