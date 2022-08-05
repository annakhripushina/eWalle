package com.example.ewalle.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.ewalle.App
import com.example.ewalle.R
import com.example.ewalle.databinding.ActivityMainBinding
import com.example.ewalle.presentation.MainActivityViewModel
import com.example.ewalle.ui.login.LoginFragment
import com.example.ewalle.ui.mainScreen.MainScreenFragment
import com.google.android.material.navigation.NavigationView
import javax.inject.Inject


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    @Inject
    lateinit var viewModel: MainActivityViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (this.applicationContext as App).appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)

        openLoginFragment()

        setContentView(binding.root)

        initNavigationMenu()

    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.mainFragmentContainer, MainScreenFragment())
                    .commit()
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun openLoginFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, LoginFragment())
            .commit()
    }

    private fun initNavigationMenu() {
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        toggle.isDrawerIndicatorEnabled = false

        initHeaderNavigationMenu()

        binding.navView.bringToFront()
        binding.navView.setNavigationItemSelectedListener(this)
        binding.navView.setCheckedItem(R.id.nav_home)

        binding.btnMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
            binding.navView.findViewById<ImageButton>(R.id.btn_close).setOnClickListener {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

    }

    private fun initHeaderNavigationMenu() {
        val header = binding.navView.getHeaderView(0)
        val user = viewModel.getUser()
        header.findViewById<TextView>(R.id.user_name).text = user.name
        header.findViewById<TextView>(R.id.user_address).text = user.address
        header.findViewById<ImageView>(R.id.user_image).setImageResource(user.image)

        binding.navView.findViewById<TextView>(R.id.logout).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragmentContainer, LoginFragment())
                .commit()
        }
    }

}