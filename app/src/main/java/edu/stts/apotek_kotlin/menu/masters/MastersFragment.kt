package edu.stts.apotek_kotlin.menu.masters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import edu.stts.apotek_kotlin.R
import org.jetbrains.anko.find

class MastersFragment : Fragment() {

    private lateinit var presenter: MastersPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        presenter = MastersPresenter(context!!)

        val pager: ViewPager = view.find(R.id.viewpager_home)
        val tabs: TabLayout = view.find(R.id.tabs_home)

        presenter.setupViewPager(pager,fragmentManager)
        tabs.setupWithViewPager(pager)

        return view
    }

}
