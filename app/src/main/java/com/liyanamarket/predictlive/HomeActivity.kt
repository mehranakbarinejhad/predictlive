package com.liyanamarket.predictlive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.liyanamarket.predictlive.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomnavigationview.background = null
        bottomnavigationview.menu.getItem(2).isEnabled = false
         bottomnavigationview.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
             R.id.mnuhome-> {addfragment(HomeFragment())
             return@setOnNavigationItemSelectedListener true }
                R.id.mnushop-> {addfragment(HomeFragment())
             return@setOnNavigationItemSelectedListener true }
            }
            false
        }

    }
    private fun addfragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frm_fragment, fragment).commit()
    }
}