package com.example.nerxavtv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.nerxavtv.data.Training
import com.example.nerxavtv.data.TrainingDao
import com.example.nerxavtv.data.TrainingDatabase
import java.util.*

class MainActivity : AppCompatActivity() {
    val viewModel: TrainingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_training)

        TrainingDatabase.getInstance(this)
        val trainingTitle: TextView = findViewById(R.id.textView2)
        val trainingTitleObserver = Observer<Training?>{
            trainingTitle.text = it?.title
        }

        val trainingDescription: TextView = findViewById(R.id.textView4)
        val trainingDescriptionObserver = Observer<Training?>{
            trainingDescription.text = it?.description
        }

        val trainingCode: TextView = findViewById(R.id.textView5)
        val trainingCodeObserver = Observer<Training?>{
            trainingCode.text = it?.code
        }

        viewModel.training.observe(this, trainingTitleObserver)
        viewModel.training.observe(this, trainingDescriptionObserver)
        viewModel.training.observe(this, trainingCodeObserver)
        viewModel.findTrainingById(1)
    }
}