package com.example.tokohmuslimapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tokohmuslimapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manageFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment? ?: return

        val navControler = manageFragment.navController

        binding.btmnvMain.setupWithNavController(navControler)

    }
}