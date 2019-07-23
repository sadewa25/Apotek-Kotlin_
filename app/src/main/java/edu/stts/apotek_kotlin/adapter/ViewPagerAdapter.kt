package edu.stts.apotek_kotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter (fm: FragmentManager?): FragmentStatePagerAdapter(fm) {

    private var dataFragment:ArrayList<Fragment> = ArrayList()
    private var dataFragmentTitle:ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return dataFragment.get(position)
    }

    override fun getCount(): Int {
        return dataFragment.size
    }

    fun addFragment(fragment: Fragment, string: String){
        dataFragment.add(fragment)
        dataFragmentTitle.add(string)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return dataFragmentTitle.get(position)
    }

}