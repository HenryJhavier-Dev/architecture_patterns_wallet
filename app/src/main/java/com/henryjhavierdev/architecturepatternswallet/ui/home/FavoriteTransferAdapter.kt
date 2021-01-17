package com.henryjhavierdev.architecturepatternswallet.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.henryjhavierdev.architecturepatternswallet.R
import com.henryjhavierdev.architecturepatternswallet.model.FavoriteTransfer
import com.squareup.picasso.Picasso

class FavoriteTransferAdapter : RecyclerView.Adapter<FavoriteTransferAdapter.FavoriteTransferViewHolder>() {

    private var favoriteTransferItems: List<FavoriteTransfer> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTransferViewHolder =
        FavoriteTransferViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.favorite_transfer_row,
                parent,
                false
            )
        )


    override fun getItemCount(): Int = favoriteTransferItems.size

    override fun onBindViewHolder(holder: FavoriteTransferViewHolder, position: Int) =
            holder.bind(favoriteTransferItems[position])

    fun setData(favoriteTransferItems: List<FavoriteTransfer>) {
        this.favoriteTransferItems = favoriteTransferItems
        notifyDataSetChanged()
    }

    class FavoriteTransferViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: FavoriteTransfer) {
            val photoImageView = view.findViewById<ImageView>(R.id.profilePhotoImageView)
            Picasso.get().load(item.photoUrl).into(photoImageView)
        }
    }


}