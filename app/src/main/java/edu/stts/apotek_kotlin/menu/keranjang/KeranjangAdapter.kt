package edu.stts.apotek_kotlin.menu.keranjang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.model.ResultItem

class KeranjangAdapter (
    val context: Context?, var dataItems: ArrayList<ResultItem?>?,
    private val listener: (ResultItem?) -> Unit):
    RecyclerView.Adapter<KeranjangAdapter.itemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.items_keranjang,parent,false)
        return itemHolder(view)
    }

    override fun getItemCount(): Int = dataItems!!.size


    override fun onBindViewHolder(holder: KeranjangAdapter.itemHolder, position: Int) {
        if (context != null) {
            holder.bind(context,dataItems!!.get(position),listener)
        }
    }

    class itemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /*val title: TextView = itemView.find(R.id.item__title)*/
        fun bind(context: Context, resultItemAPI: ResultItem?, listener: (ResultItem?) -> Unit){

            /*title.text = resultItemAPI?.name*/
            itemView.setOnClickListener { listener(resultItemAPI) }
        }
    }

}