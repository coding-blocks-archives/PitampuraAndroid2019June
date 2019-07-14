package com.codingblocks.firebasedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseDatabase.getInstance()
        val ref = db.reference.child("messages")
        var uid = ""

//        FirebaseDatabase.getInstance().reference.child("messages")
//            .child("user1")
//            .child("chat")
//            .child("text")
//            .addValueEventListener(object : ValueEventListener {
//                override fun onCancelled(p0: DatabaseError) {
//                }
//
//                override fun onDataChange(p0: DataSnapshot) {
//                    textView.text = p0.value.toString()
//                }
//
//            })

        //Rules for firebase
//        {
//            "rules": {
//            ".read": "auth.uid !== null",
//            ".write": "auth.uid !== null"
//        }
//        }
        FirebaseAuth.getInstance().signInWithEmailAndPassword(
            "aggarwalpulkit596@gmail.com",
            "12345678"
        ).addOnSuccessListener {
            uid = it.user.uid
            val chat = Chat()
            chat.text = "New text Added"
            chat.time = "12 PM"
            val key = ref.push().key
            ref.child("$uid/$key/")
                .setValue(chat)
        }

        val list = arrayListOf<Chat>()
        FirebaseDatabase.getInstance().reference.child("messages")
            .child("iCWLG6emgYgjS1j7j4y5qR5ukNn2")
            .addChildEventListener(object : ChildEventListener {
                override fun onCancelled(p0: DatabaseError) {
                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                    val result = p0.getValue(Chat::class.java)
                    result?.let { list.add(it) }
                    list.forEach {
                        textView.text = "${textView.text}  ${it.text}"
                    }
                }

                override fun onChildRemoved(p0: DataSnapshot) {
                }

            })
//        val chat = Chat()
//        chat.text = "New text Added"
//        chat.time = "12 PM"
////        FirebaseDatabase.getInstance().reference.child("messages/user1/chat1/text")
////            .setValue("New Text Added")
////        val ref = FirebaseDatabase.getInstance().reference.child("messages/user1/")
//        val key = ref.push().key
//        ref.child("$key/")
//            .setValue(chat)

    }
}

class Chat {
    var text: String = ""
    var time: String = ""
}
