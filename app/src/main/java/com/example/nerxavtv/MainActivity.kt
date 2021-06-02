package com.example.nerxavtv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nerxavtv.data.Training
import com.example.nerxavtv.data.TrainingDao
import com.example.nerxavtv.data.TrainingDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_training)
    }
}