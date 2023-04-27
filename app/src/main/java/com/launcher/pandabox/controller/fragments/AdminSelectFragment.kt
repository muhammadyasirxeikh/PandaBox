package com.launcher.pandabox.controller.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.launcher.pandabox.R
import com.launcher.pandabox.databinding.FragmentAdminSelectBinding
import com.launcher.pandabox.storage.SharedPreferenceStorrage
import com.launcher.pandabox.utils.Constant


class AdminSelectFragment : Fragment() {


    var binding: FragmentAdminSelectBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdminSelectBinding.inflate(layoutInflater, container, false)


        binding?.standalone?.setOnClickListener {

            findNavController().navigate(R.id.action_adminselectfragment_to_passwordFragment, Bundle().apply {
                putString("usertype","newuser")
            })

        }
        binding?.managed?.setOnClickListener {
            findNavController().navigate(R.id.action_adminselectfragment_to_deviceNameFragment)
            SharedPreferenceStorrage().setStringValue(requireContext(),Constant.Config.ADMIN.name,"admin")
        }



        return binding!!.root
    }


}