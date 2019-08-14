package edu.stts.apotek_kotlin.menu.keranjang


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.model.ResultItem
import kotlinx.android.synthetic.main.fragment_keranjang.*


class KeranjangFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keranjang, container, false)
    }

    private lateinit var adapter:KeranjangAdapter
    private var dataItems:ArrayList<ResultItem?>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataItems = arrayListOf()
        for(i in 0 until 50){
            dataItems?.add(ResultItem())
        }
        adapter = KeranjangAdapter(context,dataItems){}

        recyler.layoutManager = LinearLayoutManager(context)
        recyler.adapter = adapter


        adapter.notifyDataSetChanged()

    }

}
