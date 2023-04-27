package com.launcher.pandabox.controller.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.launcher.pandabox.R
import com.launcher.pandabox.controller.activity.MainActivity
import com.launcher.pandabox.databinding.FragmentSplashBinding
import com.launcher.pandabox.storage.SharedPreferenceStorrage


class Splash : Fragment() {
  
 var binding: FragmentSplashBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        var mode= SharedPreferenceStorrage().getStringValue(requireContext(),"mode","")

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                handler.removeCallbacks(this)

                if (mode.equals("standalone")) {
                    findNavController().navigate(R.id.action_splash2_to_homefragment)
                }else{
                    findNavController().navigate(R.id.action_splash2_to_adminselectfragment)
                }


            }
        }, 3000)
        return binding!!.root
    }

   
}