package com.liyanamarket.predictlive.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.liyanamarket.predictlive.R
import com.liyanamarket.predictlive.fragment.HomeFragment
import com.liyanamarket.predictlive.fragment.RankingFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomnavigationview.background = null
        bottomnavigationview.menu.getItem(2).isEnabled = false
       addfragment(HomeFragment(this))


        bottomnavigationitemclick()

        fab.setOnClickListener {
            val intent=Intent(this, PredictActivity::class.java)
            startActivity(intent)
        }

    }
    private fun addfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frm_fragment, fragment).commit()
    }

    private fun bottomnavigationitemclick(){
        bottomnavigationview.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.mnuhome -> {
                    addfragment(HomeFragment(this))
                    bottomnavigationview.menu.getItem(0).isEnabled = false
                    bottomnavigationview.menu.getItem(1).isEnabled = true
                    bottomnavigationview.menu.getItem(3).isEnabled = true
                    bottomnavigationview.menu.getItem(4).isEnabled = true
                    return@setOnNavigationItemSelectedListener true }

                R.id.mnurank ->{addfragment(RankingFragment(this))
                    bottomnavigationview.menu.getItem(3).isEnabled = false
                    bottomnavigationview.menu.getItem(0).isEnabled = true
                    bottomnavigationview.menu.getItem(1).isEnabled = true
                    bottomnavigationview.menu.getItem(4).isEnabled = true

                    return@setOnNavigationItemSelectedListener true}
            }
            false
        }
    }


}