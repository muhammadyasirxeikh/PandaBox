package com.launcher.pandabox.controller.fragments.homeFragment

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.launcher.pandabox.databinding.ItemAppMainBinding


class HomeAppsAdapter (context: Context?, appitems: List<String>) :
    RecyclerView.Adapter<HomeAppsAdapter.TopAppItemVH>() {
    private val mappitems: List<String>
    private var selectedPackages:MutableList<String>? = ArrayList()
    var binding: ItemAppMainBinding? = null
    private var context: Context? = null
    private val sharedPreferences =
        context!!.getSharedPreferences("com.codecoy.pandabox", Context.MODE_PRIVATE)

    private val editor = sharedPreferences.edit()

    init {
        mappitems = appitems
        this.context = context

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAppItemVH {
        binding = ItemAppMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopAppItemVH(binding!!)
    }

    override fun onBindViewHolder(holder: TopAppItemVH, position: Int) {
        val appItem: String = mappitems[position]

        try {
            val packageManager: PackageManager = context?.packageManager!!
            val icon: Drawable =
                context?.packageManager?.getApplicationIcon(appItem)!!
            binding?.appicon?.setImageDrawable(icon)
            binding?.appname?.text = context?.packageManager?.getApplicationLabel(packageManager.getApplicationInfo(appItem, PackageManager.GET_META_DATA))!!
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }


        binding?.appicon?.setOnClickListener {






            val launchIntent: Intent? =
            context?.packageManager?.getLaunchIntentForPackage(appItem)
            context?.startActivity(launchIntent)
        }




        //bind data



    } //onBindViewHolder




    override fun getItemCount(): Int {
        return mappitems.size
    }

    class TopAppItemVH(itemView: ItemAppMainBinding) :
        RecyclerView.ViewHolder(itemView.root) //VH
}