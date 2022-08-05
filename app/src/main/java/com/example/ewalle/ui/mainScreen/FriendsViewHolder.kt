package com.example.ewalle.ui.mainScreen

import androidx.recyclerview.widget.RecyclerView
import com.example.ewalle.data.model.Friend
import com.example.ewalle.databinding.FriendItemBinding


class FriendsViewHolder(private val binding: FriendItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Friend) {
        binding.name.text = item.name
        binding.image.setImageResource(item.image)
    }
}