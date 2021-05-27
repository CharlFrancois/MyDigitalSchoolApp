package com.example.nerxavtv

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.google.android.youtube.player.YouTubeBaseActivity


class MainActivity : YouTubeBaseActivity() {

  // Change the AppCompactActivity to YouTubeBaseActivity()

  // Add the api key that you had
  // copied from google API
  // This is a dummy api key
  val api_key = "AIzaSyCnrcRd-zMj5Sq9twBs3V9mFskq65nyRt4"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_vie_ecole)

// Get reference to the view of Video player
  //  val ytPlayer = findViewById<YouTubePlayerView>(R.id.ytPlayer)

   // ytPlayer.initialize(api_key, object : YouTubePlayer.OnInitializedListener{
      // Implement two methods by clicking on red error bulb
      // inside onInitializationSuccess method
      // add the video link or the
      // playlist link that you want to play
      // In here we also handle the play and pause functionality
    //  override fun onInitializationSuccess(
      //  provider: YouTubePlayer.Provider?,
       // player: YouTubePlayer?,
       // p2: Boolean
      //) {
       // player?.loadVideo("ZDFietBFL6s")
        //player?.play()
      //}

      // Inside onInitializationFailure
      // implement the failure functionality
      // Here we will show toast
      //override fun onInitializationFailure(
        //p0: YouTubePlayer.Provider?,
        //p1: YouTubeInitializationResult?
      //) {
        //Toast.makeText(this@MainActivity , "Video player Failed" , Toast.LENGTH_SHORT).show()
      //}
  //  }//)
  //}
}}
