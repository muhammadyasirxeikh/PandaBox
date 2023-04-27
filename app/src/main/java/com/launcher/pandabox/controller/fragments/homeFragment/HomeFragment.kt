package com.launcher.pandabox.controller.fragments.homeFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.launcher.pandabox.R
import com.launcher.pandabox.controller.activity.MainActivity
import com.launcher.pandabox.databinding.FragmentHomeBinding
import com.launcher.pandabox.storage.SharedPreferenceStorrage
import com.launcher.pandabox.utils.Constant


class HomeFragment : Fragment() ,View.OnFocusChangeListener{





    var binding: FragmentHomeBinding? = null
    var mainActivity: MainActivity? = null
    var TAG = "HomeFragment"




    var appArrayList: List<String> ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        appArrayList= SharedPreferenceStorrage().getListValue(mainActivity,Constant.Config.selectedPackages.name) as List<String>?
        Log.i(TAG, "onCreateView: $appArrayList")

        binding!!.menu.onFocusChangeListener = this
        binding!!.manageApps.onFocusChangeListener = this

        binding!!.help.onFocusChangeListener = this

        binding!!.manageApps.setOnClickListener {
            findNavController().navigate(R.id.action_homefragment_to_passwordFragment, Bundle().apply {
                putString("usertype","parent")
            })
        }
        binding!!.help.setOnClickListener {
            findNavController().navigate(R.id.action_homefragment_to_helpFragment)
        }
        binding!!.menu.setOnClickListener {
            findNavController().navigate(R.id.action_homefragment_to_passwordFragment, Bundle().apply {
                putString("usertype","settings")
            })
        }
        setupRecycler()
        return binding!!.root
    }
    private fun setupRecycler() {
        binding!!.recyclerApps.setHasFixedSize(true)
        binding?.recyclerApps?.layoutManager = androidx.recyclerview.widget.GridLayoutManager(
            requireActivity(),
            7
        )

        val adapter = appArrayList?.let { HomeAppsAdapter(mainActivity, it) }
        binding!!.recyclerApps.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onFocusChange(view: View?, isFocused: Boolean) {

                try {
                    when (view?.id) {
                        R.id.menu -> print("x == 1")
                        R.id.manage_apps -> print("x == 2")
                        R.id.help -> print("x == 2")
                        else -> {
                            print("x is neither 1 nor 2")
                        }
                    }


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }



}