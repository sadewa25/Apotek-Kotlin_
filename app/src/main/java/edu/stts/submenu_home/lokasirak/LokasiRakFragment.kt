package edu.stts.submenu_home.lokasirak


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.stts.adapter.AdapterRecyclerKategoriBarang
import edu.stts.adapter.AdapterRecyclerLokasiBarang

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.submenu_home.kategoribarang.KategoriFragmentPresenter
import edu.stts.submenu_home.kategoribarang.insert.DetailKategoriFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_lokasi_rak.*
import org.jetbrains.anko.find

class LokasiRakFragment : Fragment(),LokasiRakFragmentView {
    private lateinit var homePresenter: HomePresenter
    private lateinit var presenter: LokasiRakFragmentPresenter
    private lateinit var rvAdapter: AdapterRecyclerLokasiBarang
    private var dataLokasiBarang:ArrayList<ResultItem?>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lokasi_rak, container, false)
        homePresenter = HomePresenter()
        (view.find<FloatingActionButton>(R.id.fab)).setOnClickListener {
            homePresenter.changeFragment(fragmentManager!!,
                DetailKategoriFragment(),R.id.frame_main)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LokasiRakFragmentPresenter(requireContext(), APIResponse().response(),this)
        dataLokasiBarang = arrayListOf()
        rvAdapter = AdapterRecyclerLokasiBarang(context,dataLokasiBarang){}
        recycler_list.layoutManager = LinearLayoutManager(context)
        recycler_list.adapter = rvAdapter
        presenter.getDataLokasiRak()
    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

    override fun showDataLokasiRak(data:List<ResultItem>) {
        showToast(data?.size.toString())
        dataLokasiBarang?.clear()
        dataLokasiBarang?.addAll(data)
        rvAdapter.notifyDataSetChanged()
    }
}
