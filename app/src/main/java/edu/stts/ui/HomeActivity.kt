package edu.stts.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import edu.stts.apotek_kotlin.R
import edu.stts.apotek_kotlin.menu.masters.MastersFragment
import edu.stts.apotek_kotlin.menu.keranjang.KeranjangFragment
import edu.stts.apotek_kotlin.menu.HomeFragFragment
import edu.stts.apotek_kotlin.menu.ProfileFragment
import edu.stts.apotek_kotlin.menu.keranjang.KeranjangModel
import edu.stts.apotek_kotlin.menu.keranjang.TableMainKeranjang

class HomeActivity : AppCompatActivity() {

/*    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
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
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(TableMainKeranjang(this,sampleDataObjects(),arrayOf(
            "Header 1 n",
            "Header 2",
            "Header 3",
            "Header 4",
            "Header 5",
            "Header 6",
            "Header 7",
            "Header 8",
            "Header 9")
        ))

    }

    fun sampleDataObjects(): List<KeranjangModel> {
        val sampleObjects = ArrayList<KeranjangModel>()

        for (x in 1..21) {
            val sampleObject = KeranjangModel(
                "Col 1, Row $x",
                "Col 2, Row $x - multi-lines",
                "Col 3, Row $x",
                "Col 4, Row $x",
                "Col 5, Row $x",
                "Col 6, Row $x",
                "Col 7, Row $x",
                "Col 8, Row $x",
                "Col 9, Row $x"
            )
            sampleObjects.add(sampleObject)
        }
        return sampleObjects
    }

}
