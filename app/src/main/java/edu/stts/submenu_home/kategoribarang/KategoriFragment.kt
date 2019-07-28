package edu.stts.submenu_home.kategoribarang


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.stts.adapter.AdapterRecyclerKategoriBarang

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.ResultItem
import edu.stts.submenu_home.kategoribarang.insert.DetailKategoriFragment
import edu.stts.ui.HomePresenter
import kotlinx.android.synthetic.main.fragment_kategori.*
import org.jetbrains.anko.find


class KategoriFragment : Fragment(),KategoriFragmentView{
    private lateinit var homePresenter: HomePresenter
    private lateinit var presenter: KategoriFragmentPresenter
    private lateinit var rvAdapter: AdapterRecyclerKategoriBarang
    private var dataCategory:ArrayList<ResultItem?>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_kategori, container, false)
        homePresenter = HomePresenter()
        (view.find<FloatingActionButton>(R.id.fab)).setOnClickListener {
            homePresenter.changeFragment(fragmentManager!!,
                DetailKategoriFragment(),R.id.frame_main)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = KategoriFragmentPresenter(requireContext(), APIResponse().response(),this)
        dataCategory = arrayListOf()
        rvAdapter = AdapterRecyclerKategoriBarang(context,dataCategory){}
        recycler_list.layoutManager = LinearLayoutManager(context)
        recycler_list.adapter = rvAdapter
        presenter.getDataKategori()
    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(),message, Toast.LENGTH_SHORT).show()
    }

    override fun showCategoryData(data: List<ResultItem>) {
        showToast(data.size.toString())
        dataCategory?.clear()
        dataCategory?.addAll(data)
        rvAdapter.notifyDataSetChanged()
    }
}
