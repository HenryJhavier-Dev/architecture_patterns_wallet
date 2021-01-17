package com.henryjhavierdev.architecturepatternswallet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henryjhavierdev.architecturepatternswallet.databinding.FavoriteTransferRowBinding
import com.henryjhavierdev.architecturepatternswallet.helpers.loadImageViewFromUrl
import com.henryjhavierdev.architecturepatternswallet.model.FavoriteTransfer

class FavoriteTransferAdapter : RecyclerView.Adapter<FavoriteTransferAdapter.FavoriteTransferViewHolder>() {

    private var favoriteTransferItems: List<FavoriteTransfer> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTransferViewHolder {

        val binding =  FavoriteTransferRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTransferViewHolder(binding)

    }

    override fun getItemCount(): Int = favoriteTransferItems.size

    override fun onBindViewHolder(holder: FavoriteTransferViewHolder, position: Int) =
            holder.bind(favoriteTransferItems[position])

    fun setData(favoriteTransferItems: List<FavoriteTransfer>) {
        this.favoriteTransferItems = favoriteTransferItems
        notifyDataSetChanged()
    }

    class FavoriteTransferViewHolder(private val binding: FavoriteTransferRowBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FavoriteTransfer) = with(binding) {

            profilePhotoImageView.loadImageViewFromUrl(item.photoUrl)
            nameTextView.text               = item.name
            transferredAmountTextView.text  = item.amount.toString()

        }
    }


}