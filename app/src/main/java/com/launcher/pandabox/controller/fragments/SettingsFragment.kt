package com.launcher.pandabox.controller.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.launcher.pandabox.R
import com.launcher.pandabox.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    var binding : FragmentSettingsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)

        return binding!!.root
    }


}