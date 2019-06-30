package com.codingblocks.networking

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_list.view.image
import kotlinx.android.synthetic.main.user_list.view.name

class GithubUserAdapter(val context: Context, val userList: ArrayList<Item>) :
    RecyclerView.Adapter<GithubViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder =
        GithubViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.user_list,
                parent,
                false
            )
        )


    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }
}

class GithubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(user: Item) {
        with(itemView) {
            name.text = user.login
            Picasso.get().load(user.avatarUrl).into(image)
        }

    }
}