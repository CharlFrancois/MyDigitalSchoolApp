package com.example.nerxavtv

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.findFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class contactPage : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_page, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
            mapFragment.getMapAsync(OnMapReadyCallback {
                googleMap = it

                val localisation1 = LatLng(50.63331985473633,3.0680081844329834)
                googleMap.addMarker(MarkerOptions().position(localisation1).title("MyDigitalSchool"))
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(localisation1, 15f))
                googleMap.setOnInfoWindowClickListener {
                    MaRedirect()
                }
            })
        view.findViewById<Button>(R.id.callBtn).setOnClickListener{
            call(it)
        }
        view.findViewById<Button>(R.id.button).setOnClickListener{
            sendEmail(it)
        }
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