package com.example.simply_watered_kotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.simply_watered_kotlin.R
import com.example.simply_watered_kotlin.Model.RegionGroup


import com.squareup.picasso.Picasso


import kotlinx.android.synthetic.main.item_layout.view.*

class MyMovieAdapter(private val context: Context,private val movieList: MutableList<RegionGroup>):RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.image_movie
        val txt_name: TextView = itemView.txt_name
        val txt_team: TextView = itemView.txt_team
        val txt_createdby: TextView = itemView.txt_createdby

        fun bind(listItem: RegionGroup) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.image_movie}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.txt_name.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList[position]
        holder.bind(listItem)

//        Picasso.get().load(movieList[position].UserId).into(holder.image)
//        holder.txt_name.text = movieList[position].GroupName
//        holder.txt_team.text = movieList[position].RegionGroupDescription
        holder.txt_createdby.text = movieList[position].userId
        holder.txt_name.text=movieList[position].groupName
        holder.txt_team.text=movieList[position].regionGroupDescription
    }

}