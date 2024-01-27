package com.example.shift.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shift.R
import com.example.shift.databinding.ItemUserBinding
import com.example.shift.domain.model.UserEntity
import com.squareup.picasso.Picasso

class UsersAdapter (private val usersList: List<UserEntity>) : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        val textName = binding.textName
        val image = binding.imageView
        val phone = binding.textPhone
        val textAddress = binding.textAddress
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = usersList[position]
        holder.textName.text = "${user.name.title} ${user.name.first} ${user.name.last}"
        holder.phone.text = user.phone
        holder.textAddress.text = "${user.location.country} ${user.location.city} ${user.location.street.name}"
        Picasso.get().load(user.picture.medium).placeholder(R.drawable.user).into(holder.image)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}