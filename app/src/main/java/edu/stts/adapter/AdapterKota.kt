package edu.stts.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import edu.stts.apotek_kotlin.model.Data
import android.widget.TextView
import android.view.LayoutInflater
import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.model.ResultItem


class AdapterKota(val context: Context, val dataItems: ArrayList<ResultItem?>?):BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var views = convertView
        if (views == null) {
            views = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent, false)
        }

        // get current item to be displayed
        val currentItem = getItem(position) as ResultItem

        // get the TextView for item name and item description
        val textViewItemName = views?.findViewById(R.id.item_title) as TextView
        textViewItemName.text = currentItem.name

        return views
    }

    override fun getItem(position: Int): Any {
        return dataItems?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataItems!!.size
    }
}