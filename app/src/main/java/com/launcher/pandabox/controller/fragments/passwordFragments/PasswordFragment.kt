package com.launcher.pandabox.controller.fragments.passwordFragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.launcher.pandabox.R
import com.launcher.pandabox.controller.activity.MainActivity
import com.launcher.pandabox.databinding.FragmentPasswordBinding
import com.launcher.pandabox.storage.SharedPreferenceStorrage
import com.launcher.pandabox.utils.Constant


class PasswordFragment : Fragment() , View.OnClickListener {

    var binding:FragmentPasswordBinding? = null
    var mainActivity: MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPasswordBinding.inflate(layoutInflater, container, false)

        var usertype = arguments?.getString("usertype")

        binding!!.no0.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "0"
            }else{
                password += "0"
                binding!!.password.text = password
            }

        })

        binding!!.no1.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "1"
            }else{
                password += "1"
                binding!!.password.text = password
            }

        })

        binding!!.no2.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "2"
            }else{
                password += "2"
                binding!!.password.text = password
            }

        })

        binding!!.no3.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "3"
            }else{
                password += "3"
                binding!!.password.text = password
            }

        })

        binding!!.no4.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "4"
            }else{
                password += "4"
                binding!!.password.text = password
            }

        })

        binding!!.no5.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "5"
            }else{
                password += "5"
                binding!!.password.text = password
            }

        })

        binding!!.no6.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "6"
            }else{
                password += "6"
                binding!!.password.text = password
            }

        })


        binding!!.no7.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "7"
            }else{
                password += "7"
                binding!!.password.text = password
            }

        })

        binding!!.no8.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "8"
            }else{
                password += "8"
                binding!!.password.text = password
            }

        })

        binding!!.no9.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {

                binding!!.password.text = "9"
            }else{
                password += "9"
                binding!!.password.text = password
            }

        })

        binding!!.deleteArrow.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {


            }else{
                var pass = method(password)
                if (pass.equals("")){
                    pass = "Enter Pin"
                }
                Log.i("TAG", "onCreateView: $pass")
                binding!!.password.text = pass
            }

        })

        binding!!.submit.setOnClickListener(View.OnClickListener {

            var password = binding!!.password.text.toString()
            if (password.equals("Enter Pin")) {
                Toast.makeText(context, "Please Enter Pin", Toast.LENGTH_SHORT).show()
            }else if (password.length<4) {
                Toast.makeText(context, "Pin must be 4 characters", Toast.LENGTH_SHORT).show()
            }else{
                if (usertype.equals("newuser")){
                    findNavController().navigate(R.id.action_passwordFragment_to_confirmPassword,Bundle().apply {
                        putString(Constant.Config.PASSWORD.name,password)
                    })
                }else if(usertype.equals("parent")){
                    val savedPassword= SharedPreferenceStorrage().getStringValue(context, Constant.Config.PASSWORD.name, "")
                    if (!savedPassword.equals("") && savedPassword.equals(password)){
                        findNavController().navigate(R.id.action_passwordFragment_to_parentFragment)
//                        startActivity(Intent(mainActivity, UsageStatsActivity::class.java))
                    }else{

                        Toast.makeText(context, "Wrong Pin", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    val savedPassword= SharedPreferenceStorrage().getStringValue(context, Constant.Config.PASSWORD.name, "")
                    if (!savedPassword.equals("") && savedPassword.equals(password)){
                        findNavController().navigate(R.id.action_passwordFragment_to_settingsFragment)
                    }else{
                        Toast.makeText(context, "Wrong Pin", Toast.LENGTH_SHORT).show()
                    }

                }

            }
        })









        return binding!!.root
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
    fun method(str: String?): String? {
        var str = str
        if (str != null && str.length > 0 ) {
            str = str?.substring(0, str.length - 1)
        }
        return str
    }

    override fun onClick(p0: View?) {
       var id=p0?.id

    }


}