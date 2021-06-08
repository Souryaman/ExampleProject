package com.example.mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.data.model.Users
import com.example.mvvm.data.model.UsersItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter (val data : List<UsersItem>): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= UserViewHolder(LayoutInflater
        .from(parent.context).inflate(R.layout.item_user,parent,false))


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}

class UserViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    fun bind(item : UsersItem) = with(itemView){
        user_nametv.text = item.login
        Picasso.get().load(item.avatarUrl).into(user_imageView)
    }
}
