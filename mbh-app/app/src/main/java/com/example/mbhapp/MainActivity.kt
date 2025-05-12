package com.example.mbhapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mbhapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val isLoggedIn = checkLoginStatus()

        navView.menu.clear()

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = if (isLoggedIn) AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_routine, R.id.navigation_notifications, R.id.navigation_account
            )
        ) else AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_routine, R.id.navigation_account
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun checkLoginStatus(): Boolean {
        // 예시: SharedPreferences에서 로그인 여부 확인
        val prefs = getSharedPreferences("auth", MODE_PRIVATE)
        return prefs.getBoolean("logged_in", false)
    }
}