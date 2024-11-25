package com.example.ud04_1_inbox

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //Recuperar el elemento padre
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)


        //Controlador de navegación
       val navHostFragment = supportFragmentManager.findFragmentById(R.id.container_fragment) as NavHostFragment
       val navController = navHostFragment.navController


        val appBarConfiguration = AppBarConfiguration.Builder(navController.graph)

        //Indico que hay un elemento openable
        appBarConfiguration.setOpenableLayout(drawerLayout)
        var appBarBuild = appBarConfiguration.build()

        //Navigation View
        val navigationView = findViewById<NavigationView>(R.id.nav_side)
        navigationView.setupWithNavController(navController)

        //toolbar con Controller
        toolbar.setupWithNavController(navController, appBarBuild)

        //bottombar con controller
        val bottomBar = findViewById<BottomNavigationView>(R.id.botton_navigation)
        bottomBar.setupWithNavController(navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.container_fragment)
        return  NavigationUI.onNavDestinationSelected(item, navController) ||
        super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

}