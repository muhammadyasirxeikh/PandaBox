package com.launcher.pandabox.controller.fragments.parentFragment

import android.app.usage.UsageStats
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.launcher.pandabox.databinding.UsageStatsItemBinding

class UsageStatsAdapter(context: Context?, UsageStatsModels: List<UsageStats>?) :
    RecyclerView.Adapter<UsageStatsAdapter.TopUsageStatsModelVH>() {
    private var mUsageStatsModels: List<UsageStats> ?=null
    private var selectedPackages:MutableList<String>? = ArrayList()
    var binding: UsageStatsItemBinding? = null
    private var context: Context? = null
    private val sharedPreferences =
        context!!.getSharedPreferences("com.codecoy.pandabox", Context.MODE_PRIVATE)

    private val editor = sharedPreferences.edit()

    init {
        if (UsageStatsModels != null) {
            mUsageStatsModels = UsageStatsModels
        }
        this.context = context

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopUsageStatsModelVH {
        binding = UsageStatsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopUsageStatsModelVH(binding!!)
    }

    override fun onBindViewHolder(holder: TopUsageStatsModelVH, position: Int) {
        val mUsageStatsModel: UsageStats = mUsageStatsModels!![position]


        binding?.packageName?.text=mUsageStatsModel.packageName

        binding?.usageTime?.text=mUsageStatsModel.totalTimeInForeground.toString()

        //bind data



    } //onBindViewHolder




    override fun getItemCount(): Int {
        return mUsageStatsModels!!.size
    }

    class TopUsageStatsModelVH(itemView: UsageStatsItemBinding) :
        RecyclerView.ViewHolder(itemView.root) //VH
}