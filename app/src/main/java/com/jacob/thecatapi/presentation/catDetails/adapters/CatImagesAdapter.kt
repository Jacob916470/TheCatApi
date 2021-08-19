package com.jacob.thecatapi.presentation.catDetails.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jacob.thecatapi.R
import com.jacob.thecatapi.data.network.models.images.CatImagesResponseItem
import com.jacob.thecatapi.presentation.catDetails.view.CatDetailsFragment

class CatImagesAdapter(
    private val catApiList: List<CatImagesResponseItem>,
    catDetailsFragment: CatDetailsFragment
) : RecyclerView.Adapter<CatImagesAdapter.CatImages>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatImages {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_images, parent, false)
        return CatImages(view)
    }

    override fun onBindViewHolder(holder: CatImages, position: Int) {
        val cat = catApiList[position]
        Glide
            .with(holder.view.context)
            .load(cat.url)
            .into(holder.imagev)
    }

    override fun getItemCount() = catApiList.size
    class CatImages(val view: View) : RecyclerView.ViewHolder(view) {
        val imagev = view.findViewById<AppCompatImageView>(R.id.im)
    }
}