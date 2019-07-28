package edu.stts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.model.ResultItem
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.find

class AdapterRecyclerKemasan( val context: Context?, var dataItems: ArrayList<ResultItem?>?,
                              private val listener: (ResultItem?) -> Unit):
    RecyclerView.Adapter<AdapterRecyclerKemasan.itemHolder>(), AnkoLogger {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recyler,parent,false)
        return itemHolder(view)
    }

    override fun getItemCount(): Int = dataItems!!.size

    override fun onBindViewHolder(itemholder: itemHolder, position: Int) {
        if (context != null) {
            itemholder.bind(context,dataItems!!.get(position),listener)
        }
    }

    class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView), AnkoLogger {

        val title:TextView = itemView.find(R.id.item__title)
        fun bind(context: Context,resultItemAPI: ResultItem?,listener: (ResultItem?) -> Unit){

            title.text = resultItemAPI?.name
            itemView.setOnClickListener { listener(resultItemAPI) }
        }
    }

}