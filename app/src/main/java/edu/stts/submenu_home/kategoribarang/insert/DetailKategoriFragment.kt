package edu.stts.submenu_home.kategoribarang.insert


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import edu.stts.adapter.AdapterRecyclerKategoriBarang

import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.client.APIResponse
import edu.stts.apotek_kotlin.model.ResultItem
import kotlinx.android.synthetic.main.fragment_insert_kategori.*
import kotlinx.android.synthetic.main.fragment_kategori.*

class DetailKategoriFragment : Fragment(),DetailKategoriView, View.OnClickListener{
    private lateinit var presenter: DetailKategoriPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_insert_kategori, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = DetailKategoriPresenter(requireContext(),APIResponse().response(),this)
        btn_simpan.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_simpan -> {
                presenter.uploadData(ResultItem(name = et_namakategori.text.toString()))
            }
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_SHORT).show()
    }

}
