package com.codingblocks.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseExceptionMapper
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val auth by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (auth.currentUser != null) {
            button.setOnClickListener {
                auth.signInWithEmailAndPassword(edtvEail.text.toString(), edtvPass.text.toString())
                    .addOnCompleteListener {
                        button.isEnabled = false
                    }.addOnSuccessListener {
                        button.isEnabled = true
                        Toast.makeText(this, "Signed In Successfully", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
            }
        } else {

            button.setOnClickListener {
                auth.createUserWithEmailAndPassword(edtvEail.text.toString(), edtvPass.text.toString())
                    .addOnCompleteListener {
                        button.isEnabled = false
                    }.addOnSuccessListener {
                        button.isEnabled = true
                        Toast.makeText(this, "Created Account Successfully", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}
