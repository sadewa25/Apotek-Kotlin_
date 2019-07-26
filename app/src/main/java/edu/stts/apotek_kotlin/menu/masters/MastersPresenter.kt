package edu.stts.apotek_kotlin.menu.masters

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.adapter.ViewPagerAdapter
import edu.stts.submenu_home.*
import edu.stts.submenu_home.kategoribarang.KategoriFragment
import edu.stts.submenu_home.supplier.SupplierFragment

class MastersPresenter(val context: Context) {

    fun setupViewPager(viewPager: ViewPager, manager: FragmentManager?){
        var adapter: ViewPagerAdapter = ViewPagerAdapter(manager)
        adapter.addFragment(ProdukFragment(), context?.getString(R.string.title_produk)!!)
        adapter.addFragment(PrincipalFragment(),context?.getString(R.string.title_principal)!!)
        adapter.addFragment(SupplierFragment(),context?.getString(R.string.title_supplier)!!)
        adapter.addFragment(KategoriFragment(),context?.getString(R.string.title_kategori)!!)
        adapter.addFragment(KemasanFragment(),context?.getString(R.string.title_kemasan)!!)
        adapter.addFragment(LokasiRakFragment(),context?.getString(R.string.title_lokasirak)!!)

        viewPager.adapter = adapter
    }

}