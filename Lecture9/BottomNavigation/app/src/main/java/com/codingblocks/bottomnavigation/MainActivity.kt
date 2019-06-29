package com.codingblocks.bottomnavigation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.activity_main.rootView
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.navigation_home -> {
            supportFragmentManager.beginTransaction().replace(R.id.container, BlankFragment())
                .commit()
            true
        }
        R.id.navigation_dashboard -> {
            supportFragmentManager.beginTransaction().replace(R.id.container, BlankFragment2())
                .commit()
            true
        }
        R.id.navigation_notifications -> {
        Snackbar.make(rootView,"Snackbar Displayed",Snackbar.LENGTH_SHORT).setAction("Undo",{


        })
            true
        }
        else -> false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(intentFor<Main2Activity>("id" to 5,"name" to "Pulkit"))
        toast("Hello World")


        nav_view.setOnNavigationItemSelectedListener(this)
    }
}
