package com.example.headhunterfromaliexpress

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.headhunterfromaliexpress.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var navHostFragment = supportFragmentManager.findFragmentByTag("NavHost")
                as? NavHostFragment

        if (navHostFragment == null) {
            navHostFragment = NavHostFragment.create(R.navigation.mobile_navigation)

            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_container, navHostFragment, "NavHost")
                .setPrimaryNavigationFragment(navHostFragment)
                .commit()
            supportFragmentManager.executePendingTransactions()
        }

        val navView: BottomNavigationView = binding.navView

        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_search,
                R.id.navigation_favorites,
                R.id.navigation_responses,
                R.id.navigation_messages,
                R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}