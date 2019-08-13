package edu.stts.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.menu.masters.MastersFragment
import edu.stts.apotek_kotlin.menu.keranjang.KeranjangFragment
import edu.stts.apotek_kotlin.menu.HomeFragFragment
import edu.stts.apotek_kotlin.menu.ProfileFragment

class HomeActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                presenter.changeFragment(supportFragmentManager, HomeFragFragment(),R.id.frame_main)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                presenter.changeFragment(supportFragmentManager,
                    KeranjangFragment(),R.id.frame_main)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                presenter.changeFragment(supportFragmentManager,ProfileFragment(),R.id.frame_main)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_master -> {
                presenter.changeFragment(supportFragmentManager,MastersFragment(),R.id.frame_main)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private lateinit var presenter:HomePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        presenter = HomePresenter()

        presenter.changeFragment(supportFragmentManager, MastersFragment(),R.id.frame_main)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

}
