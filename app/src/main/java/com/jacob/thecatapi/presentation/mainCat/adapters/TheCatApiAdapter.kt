package com.jacob.thecatapi.presentation.mainCat.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jacob.thecatapi.R
import com.jacob.thecatapi.data.network.models.breeds.TheCatApiResponseItem
import com.jacob.thecatapi.presentation.core.callBack.OnItemClickListener
import com.jacob.thecatapi.presentation.core.callBack.ResultCallBack


class TheCatApiAdapter(
    private val catApiList: List<TheCatApiResponseItem>,
    private val onItemClickListener: OnItemClickListener<TheCatApiResponseItem>,
    private val onResultCallBack: ResultCallBack<TheCatApiResponseItem>
): RecyclerView.Adapter<TheCatApiAdapter.TheCatApiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheCatApiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cats,parent,false)
        return TheCatApiViewHolder(view)
    }

    override fun onBindViewHolder(holder: TheCatApiViewHolder, position: Int) {
        val cat = catApiList[position]
        Glide
            .with(holder.view.context)
            .load(cat.image?.url)
            .into(holder.imagev)
        holder.name.text = "Catname: ${cat.name}"
        holder.origin.text = "Origin: ${cat.origin}"
        holder.ratingB?.rating = cat.affection_level.toFloat()
        holder.container.setOnClickListener {
            onItemClickListener.onItemClick(cat)
        }
        holder.imagev.setOnClickListener {
            onResultCallBack.onSuccess(cat)
        }
    }

    override fun getItemCount() = catApiList.size

    class TheCatApiViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val imagev = view.findViewById<AppCompatImageView>(R.id.imageCat)
        val name = view.findViewById<TextView>(R.id.txtName)
        val origin = view.findViewById<TextView>(R.id.txtOrigin)
        val ratingB = view.findViewById<RatingBar>(R.id.affectiveRaiting)
        val container = view.findViewById<CardView>(R.id.lContainer)

    }
}

