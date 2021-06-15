package com.example.nerxavtv
import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.nerxavtv.data.Training
import com.example.nerxavtv.data.TrainingDao
import com.example.nerxavtv.data.TrainingDatabase
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val navHostFragment = supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = navHostFragment.navController

        bottomNavigationView.setupWithNavController(navController)

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