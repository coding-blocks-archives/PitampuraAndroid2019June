package com.codingblocks.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.codingblocks.mvvm.viewmodels.MainActivityViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mainActivityViewMode by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainActivityViewMode.queryRepo()


        mainActivityViewMode.getUser().observe(this, Observer {user ->
            Picasso.get().load(user.avatar_url).into(imageView)
            textView.text = user.name
            textView2.text = user.login

        })
    }
}
