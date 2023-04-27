package com.launcher.pandabox.controller.fragments.passwordFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.launcher.pandabox.R
import com.launcher.pandabox.databinding.FragmentConfirmPasswordBinding
import com.launcher.pandabox.storage.SharedPreferenceStorrage
import com.launcher.pandabox.utils.Constant


class ConfirmPassword : Fragment() {

    var binding : FragmentConfirmPasswordBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmPasswordBinding.inflate(layoutInflater, container, false)

        var old_password  = arguments?.getString(Constant.Config.PASSWORD.name)

        binding!!.no0.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "0"
            }else{
                password += "0"
                binding!!.password.text = password
            }

        })

        binding!!.no1.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "1"
            }else{
                password += "1"
                binding!!.password.text = password
            }

        })

        binding!!.no2.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "2"
            }else{
                password += "2"
                binding!!.password.text = password
            }

        })

        binding!!.no3.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "3"
            }else{
                password += "3"
                binding!!.password.text = password
            }

        })

        binding!!.no4.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "4"
            }else{
                password += "4"
                binding!!.password.text = password
            }

        })

        binding!!.no5.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "5"
            }else{
                password += "5"
                binding!!.password.text = password
            }

        })

        binding!!.no6.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "6"
            }else{
                password += "6"
                binding!!.password.text = password
            }

        })


        binding!!.no7.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "7"
            }else{
                password += "7"
                binding!!.password.text = password
            }

        })

        binding!!.no8.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "8"
            }else{
                password += "8"
                binding!!.password.text = password
            }

        })

        binding!!.no9.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {

                binding!!.password.text = "9"
            }else{
                password += "9"
                binding!!.password.text = password
            }

        })

        binding!!.deleteArrow.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {


            }else{
                var pass = method(password)
                if (pass.equals("")){
                    pass = "ReEnter Pin"
                }
                Log.i("TAG", "onCreateView: $pass")
                binding!!.password.text = pass
            }

        })

        binding!!.submit.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("ReEnter Pin")) {
                Toast.makeText(context, "Please ReEnter Pin", Toast.LENGTH_SHORT).show()
            }else if (password.length<4) {
                Toast.makeText(context, "Pin must be 4 characters", Toast.LENGTH_SHORT).show()
            }else{
               if(password.equals(old_password)){
                   SharedPreferenceStorrage().setStringValue(context, Constant.Config.PASSWORD.name, password)
                   findNavController().navigate(R.id.action_confirmPassword_to_allAppsFragment)
                   SharedPreferenceStorrage().setStringValue(requireContext(),"mode","standalone")
               }else{
                     Toast.makeText(context, "Pin does not matched", Toast.LENGTH_SHORT).show()
               }
            }
        })

        return binding!!.root
    }
    fun method(str: String?): String? {
        var str = str
        if (str != null && str.length > 0 ) {
            str = str?.substring(0, str.length - 1)
        }
        return str
    }

}