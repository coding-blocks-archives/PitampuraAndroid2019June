package com.codingblocks.networkokhttp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codingblocks.networkokhttp.R
import com.codingblocks.networkokhttp.modal.User
import kotlinx.android.synthetic.main.layout_users.view.*

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
            }

        }

    }
}