package com.launcher.pandabox.controller.fragments.parentFragment

import android.app.usage.UsageStats
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Context.USAGE_STATS_SERVICE
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.launcher.pandabox.controller.activity.MainActivity
import com.launcher.pandabox.databinding.FragmentParentBinding
import com.launcher.pandabox.storage.SharedPreferenceStorrage
import com.launcher.pandabox.utils.Constant
import java.util.*

class ParentFragment : Fragment() {
    // TODO: Rename and change types of parameters

    var binding:FragmentParentBinding? = null
    var mainActivity: MainActivity? = null

    var appArrayList: List<String> ?= null
    var usageStats: List<UsageStats>?=null
//    var usageStatsArrayList: List<UsageStats> = List<UsageStats>()
    private val  TAG:String="ParentFragment"
    var adapter:UsageStatsAdapter?=null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val rightNow: Calendar = Calendar.getInstance()


// offset to add since we're not UTC


// offset to add since we're not UTC
        val offset: Int = rightNow.get(Calendar.ZONE_OFFSET) +
                rightNow.get(Calendar.DST_OFFSET)

        val sinceMidnight: Long = (rightNow.getTimeInMillis() + offset) %
                (24 * 60 * 60 * 1000)

        println("$sinceMidnight milliseconds since midnight")



        appArrayList= SharedPreferenceStorrage().getListValue(mainActivity, Constant.Config.selectedPackages.name)
        binding = FragmentParentBinding.inflate(layoutInflater, container, false)
//        val mUsageStatsManager =
//            mainActivity!!.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager
//        val lUsageStatsMap =
//            mUsageStatsManager.queryAndAggregateUsageStats(sinceMidnight-60 * 60 * 1000,sinceMidnight)
//
//        val totalTimeUsageInMillis = lUsageStatsMap["com.android.vending"]!!.totalTimeInForeground
//        Log.e( "APP" , "$totalTimeUsageInMillis" )
//        var foregroundAppPackageName : String? = null
//        val currentTime = System.currentTimeMillis()
//
//        val usageEvents = mUsageStatsManager.queryEvents( currentTime - (1000*60*10) , currentTime )
//        val usageEvent = UsageEvents.Event()
//        while ( usageEvents.hasNextEvent() ) {
//            usageEvents.getNextEvent( usageEvent )
////            Log.e( "APP" , "${usageEvent.packageName} ${usageEvent.timeStamp}" )
//            if (appArrayList!!.contains(usageEvent.packageName)){
//                val packageManager = mainActivity!!.packageManager
//                val info = packageManager.getApplicationInfo(usageEvent.packageName, PackageManager.GET_META_DATA)
//                val appName = packageManager.getApplicationLabel(info) as String
//
//                usageStatsArrayList.add(UsageStatsModel(appName,usageEvent.timeStamp.toString()))
//                usageStatsArrayList.distinct()
//            }
//        }




        val beginTime = System.currentTimeMillis()

        val detectApp = object : TimerTask() {

            @RequiresApi(Build.VERSION_CODES.O)
            override fun run() {
//                sp = getSharedPreferences(getString(R.string.app_duration), MODE_PRIVATE)
//                val powerManager = getSystemService(POWER_SERVICE) as PowerManager
//                editor = sp.edit()
                var mUsageStatsManager = mainActivity!!.getSystemService(
                    USAGE_STATS_SERVICE
                ) as UsageStatsManager
                val endTime = System.currentTimeMillis()
                val beginTime = endTime - (1000 * 60 * 10)


                usageStats = mUsageStatsManager.queryUsageStats(
                    UsageStatsManager.INTERVAL_BEST,
                    beginTime,
                    endTime
                )

//                for (j in appArrayList!!) {
//

//                    for (i in usageStats) {
//
//                        if(j == i.packageName){
//                            usageStatsArrayList.add(i)
//                            Log.i(
//                                TAG,
//                                "run: UsageStats ${i.packageName} and ${i.totalTimeInForeground}"
//                            )
//                        }
//
//
//                    }
//                }

//                Log.i(TAG, "run: $usageStatsArrayList")
//                adapter?.notifyDataSetChanged()
            }


        }
        Timer().scheduleAtFixedRate(detectApp, 0, 0)
//                GlobalData.list = usageStats

setupRecycler()





        // Inflate the layout for this fragment
        return binding!!.root
    }
    private fun setupRecycler() {
        binding!!.pkgList.setHasFixedSize(true)
        binding?.pkgList?.layoutManager = androidx.recyclerview.widget.GridLayoutManager(
            requireActivity(),
            3
        )


        adapter = UsageStatsAdapter(mainActivity,usageStats)
        binding!!.pkgList.adapter = adapter
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }
}