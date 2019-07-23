package edu.stts.apotek_kotlin.menu.home

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.adapter.ViewPagerAdapter
import edu.stts.submenu_home.*

class HomeFragPresenter(val context: Context) {

    fun setupViewPager(viewPager: ViewPager, manager: FragmentManager?){
        var adapter: ViewPagerAdapter = ViewPagerAdapter(manager)
        adapter.addFragment(ProdukFragment(), context?.getString(R.string.title_produk)!!)
        adapter.addFragment(KategoriFragment(),context?.getString(R.string.title_kategori)!!)
        adapter.addFragment(KemasanFragment(),context?.getString(R.string.title_kemasan)!!)
        adapter.addFragment(LokasiRakFragment(),context?.getString(R.string.title_lokasirak)!!)
        adapter.addFragment(PrincipalFragment(),context?.getString(R.string.title_principal)!!)
        adapter.addFragment(SupplierFragment(),context?.getString(R.string.title_supplier)!!)

        viewPager.adapter = adapter
    }

}