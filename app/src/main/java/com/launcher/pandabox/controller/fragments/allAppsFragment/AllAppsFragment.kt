package com.launcher.pandabox.controller.fragments.allAppsFragment

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.launcher.pandabox.R
import com.launcher.pandabox.controller.activity.MainActivity
import com.launcher.pandabox.databinding.FragmentAllAppsBinding
import java.util.*

class AllAppsFragment : Fragment() {



    var binding: FragmentAllAppsBinding? = null

    var mainActivity: MainActivity? = null

    var appArrayList: ArrayList<AppItem> = ArrayList<AppItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllAppsBinding.inflate(layoutInflater, container, false)

        getAllInstalledPackges()
        binding!!.submit.setOnClickListener {
           findNavController().navigate(R.id.action_allAppsFragment_to_homefragment)
        }
        return binding!!.root
    }


    private fun getAllInstalledPackges() {
        try {
            appArrayList.clear()
            val mPackageManager: PackageManager = requireActivity().getPackageManager()
            val intent = Intent(Intent.ACTION_MAIN, null)
            intent.addCategory(Intent.CATEGORY_LAUNCHER)
            val avaiableActivities = mPackageManager.queryIntentActivities(intent, 0)
            for (appIs in avaiableActivities) {
                var banner: Drawable? = null
                banner = appIs.activityInfo.loadIcon(mPackageManager)
                if (banner == null) {
                    banner = appIs.activityInfo.applicationInfo.loadIcon(mPackageManager)
                }
                if (banner == null) banner = appIs.activityInfo.loadBanner(mPackageManager)
                if (banner == null) {
                    banner = appIs.activityInfo.applicationInfo.loadBanner(mPackageManager)
                }
                val appNameIs = appIs.loadLabel(mPackageManager)
                if (appNameIs.equals("PandaBox")) {

                }else{
                    appArrayList.add(AppItem(appIs.activityInfo.packageName, appNameIs, banner))
                    Log.i("TAG", "getAllInstalledPackges:     $appNameIs")
                }

            }
            setupRecycler()
//            Collections.sort(
//                appArrayList,
//                com.zvision.zlaunchertwo.AllAppsActivity.AppNameComparator()
//            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setupRecycler() {
        binding!!.allAppsRecyclerView.setHasFixedSize(true)
        binding?.allAppsRecyclerView?.layoutManager = androidx.recyclerview.widget.GridLayoutManager(
            requireActivity(),
            3
        )

        val adapter = AllAppsAdapter(mainActivity,appArrayList)
        binding!!.allAppsRecyclerView.adapter = adapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
}