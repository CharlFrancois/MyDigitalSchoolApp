package com.example.nerxavtv

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_contact_page)

        mapFragment = supportFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it

            val localisation1 = LatLng(50.63331985473633,3.0680081844329834)
            googleMap.addMarker(MarkerOptions().position(localisation1).title("MyDigitalSchool"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(localisation1, 15f))
            googleMap.setOnInfoWindowClickListener {
                MaRedirect()
            }
        })
    }

    fun call(view: View) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + "+33366060696")
        startActivity(dialIntent)
    }

    fun sendEmail(view: View){
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto: lille@mydigitalschool.com")
        startActivity(intent)
    }

    fun MaRedirect() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, "https://www.mydigitalschool.com/ecole-multimedia-lille")
        startActivity(intent)
    }
}