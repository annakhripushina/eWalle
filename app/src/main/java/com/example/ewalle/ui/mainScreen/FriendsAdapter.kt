package com.example.ewalle.ui.mainScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ewalle.data.model.Friend
import com.example.ewalle.databinding.FriendItemBinding

class FriendsAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Friend> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = FriendItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FriendsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FriendsViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int =
        items.size

}