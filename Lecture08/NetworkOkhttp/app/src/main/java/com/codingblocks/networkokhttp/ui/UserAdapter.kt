package com.codingblocks.networkokhttp.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingblocks.networkokhttp.R
import com.codingblocks.networkokhttp.modal.Post
import com.codingblocks.networkokhttp.modal.User
import com.codingblocks.networkokhttp.network.RetrofitClient
import kotlinx.android.synthetic.main.layout_users.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserAdapter(private val users:List<User>):
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = li.inflate(R.layout.layout_users,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(user: User){
            with(itemView){
                tvEmail.text = user.email
                tvUsername.text = user.username
                tvName.text = user.name


                setOnClickListener {
                    val api = RetrofitClient.postsApi

                    api.getPostsByUserId(user.id).enqueue(object : Callback<List<Post>>{
                        override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                        }

                        override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                            val data = response.body()
                            data?.forEach {
                                Log.i("PUI","""
                                    
                                    
                                    userId:: ${it.userId}
                                    title:: ${it.title}
                                    ~~~~~~~~~~~~~~~~~~~~~~
                                """.trimIndent())
                            }
                        }
                    })
                }
            }

        }

    }
}