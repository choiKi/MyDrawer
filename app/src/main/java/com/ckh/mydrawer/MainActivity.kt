package com.ckh.mydrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.ckh.mydrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item1 -> {
                    onFragmentSelected(0)
                }
                R.id.item2 -> {
                    onFragmentSelected(1)
                }
                R.id.item3 -> {
                    onFragmentSelected(2)
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)  //닫을때 왼쪽으로 붙여라
            return@setNavigationItemSelectedListener true
        }
    }
    private fun onFragmentSelected(index: Int) {
        var fragment: Fragment = Fragment1()
        when(index) {
            0 -> {
                binding.toolbar.title = "첫번째 화면"
                fragment = Fragment1()
            }
            1 -> {
                binding.toolbar.title = "두번째 화면"
                fragment = Fragment1()
            }
            2 -> {
                binding.toolbar.title = "세번째 화면"
                fragment = Fragment1()
            }
        }

        with(supportFragmentManager.beginTransaction()){
            replace(R.id.container,fragment)
        }.commit()
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}