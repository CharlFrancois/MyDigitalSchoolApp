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

    // on crée une variable map framgent qui va contenir le framgent avec notre google map
    lateinit var mapFragment: SupportMapFragment

    //on crée notre variable googleMap
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
        //return le fragment contact

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            //on récupère la carte
            mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
            mapFragment.getMapAsync(OnMapReadyCallback {
                googleMap = it

                //on indique les coordonées de l'endroit que l'on veut afficher
                val localisation1 = LatLng(50.63331985473633,3.0680081844329834)

                //on ajoute un marquer au coordonnée : MyDigitalSchool
                googleMap.addMarker(MarkerOptions().position(localisation1).title("MyDigitalSchool"))

                // On redirige la caméra vers les coodonées et on zoom
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(localisation1, 15f))
                googleMap.setOnInfoWindowClickListener {
                    MaRedirect()
                    //on récupère le clic du marker puis on utilisa la méthode MaRedirect
                }
            })
        // on récupère le click du bouton puis on éxecute la méthode call
        view.findViewById<Button>(R.id.callBtn).setOnClickListener{
            call(it)
        }
        // on récupère le click du bouton puis on éxecute la méthode sendEmail
        view.findViewById<Button>(R.id.button).setOnClickListener{
            sendEmail(it)
        }
    }
    // call permet d'ouvrir l'onglet téléphone de l'appareil
    fun call(view: View) {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        //on indique le numéro que l'on veut pré-appeler
        dialIntent.data = Uri.parse("tel:" + "+33366060696")
        startActivity(dialIntent)
    }

    // sendEmail permet d'ouvrir l'onget email de l'appareil
    fun sendEmail(view: View){
        val intent = Intent(Intent.ACTION_SENDTO)
        //mailto correspond au destinateur à qui envoyer le mail
        intent.data = Uri.parse("mailto: lille@mydigitalschool.com")
        startActivity(intent)
    }

    // MaRedirect peremt de rediriger vers l'onget
    fun MaRedirect() {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
            // on execute une recherche sur un navigateur internet avec l'url suivante
        intent.putExtra(SearchManager.QUERY, "https://www.mydigitalschool.com/ecole-multimedia-lille")
        startActivity(intent)
    }
}