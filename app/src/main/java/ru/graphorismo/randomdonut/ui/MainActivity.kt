package ru.graphorismo.randomdonut.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import ru.graphorismo.randomdonut.R
import ru.graphorismo.randomdonut.data.repository.DonutRepository
import ru.graphorismo.randomdonut.ui.stateholders.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    lateinit var textView: TextView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(R.drawable.ic_baseline_cookie_24)
        textView = findViewById<TextView>(R.id.textView)
        textView.setText(R.string.placeholder)
        findViewById<Button>(R.id.button)
            .setOnClickListener(){
                viewModel.updateDonutData()
            }

        viewModel.donutData.observe(this){
            if( it != null){
                try{
                    textView.setText("${it.name}\n${it.description}")
                    imageView.load(it.imageUrl)
                }catch (ex: Exception){
                    Log.e("DONUT","Cant update text and image: ${ex.message}")
                }
            }
        }

    }
}