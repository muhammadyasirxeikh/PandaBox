package com.launcher.pandabox.controller.fragments.allAppsFragment

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.launcher.pandabox.databinding.ItemAppSelectBinding
import com.launcher.pandabox.storage.SharedPreferenceStorrage
import com.launcher.pandabox.utils.Constant


class AllAppsAdapter(context: Context?, appitems: ArrayList<AppItem>) :
    RecyclerView.Adapter<AllAppsAdapter.TopAppItemVH>() {
    private val mappitems: List<AppItem>
    private var selectedPackages:MutableList<String>? = ArrayList()
    var binding: ItemAppSelectBinding? = null
    private var context: Context? = null
    private val sharedPreferences =
        context!!.getSharedPreferences("com.codecoy.pandabox", Context.MODE_PRIVATE)

    private val editor = sharedPreferences.edit()

    init {
        mappitems = appitems
        this.context = context

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAppItemVH {
        binding = ItemAppSelectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopAppItemVH(binding!!)
    }

    override fun onBindViewHolder(holder: TopAppItemVH, position: Int) {
        val appItem: AppItem = mappitems[position]

        binding?.appname?.text=appItem.__appName
        binding?.appicon?.setImageDrawable(appItem.__appIcon)

        binding?.checkBox?.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener() { buttonView, isChecked ->
            if (isChecked) {
                // do something when check is selected
                selectedPackages?.add(appItem.__packgeName.toString())
                Log.i("TAG", "onBindViewHolder:   $selectedPackages")
                SharedPreferenceStorrage().setListvalue(context, Constant.Config.selectedPackages.name, selectedPackages)

            } else {
                //do something when unchecked
                selectedPackages?.remove(appItem.__packgeName)
                Log.i("TAG", "onBindViewHolder:   $selectedPackages")

                SharedPreferenceStorrage().setListvalue(context, Constant.Config.selectedPackages.name, selectedPackages)


            }
        })
        //bind data



    } //onBindViewHolder




    override fun getItemCount(): Int {
        return mappitems.size
    }

    class TopAppItemVH(itemView: ItemAppSelectBinding) :
        RecyclerView.ViewHolder(itemView.root) //VH
}