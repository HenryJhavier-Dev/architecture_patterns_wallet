package com.henryjhavierdev.architecturepatternswallet.ui.transfer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.henryjhavierdev.architecturepatternswallet.R
import com.henryjhavierdev.architecturepatternswallet.databinding.TransferRowBinding
import com.henryjhavierdev.architecturepatternswallet.helpers.OnItemSelected
import com.henryjhavierdev.architecturepatternswallet.model.TransferAccount
import com.squareup.picasso.Picasso

class TransferAccountsAdapter( private val onItemSelectedListener: OnItemSelected<TransferAccount>) :
    RecyclerView.Adapter<TransferAccountsAdapter.TransferAccountViewHolder>() {

    private var transferAccountList: List<TransferAccount> = emptyList()


    fun setTransferAccountList(transferAccountList: List<TransferAccount>) {
        this.transferAccountList = transferAccountList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferAccountViewHolder {
        val binding =  TransferRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransferAccountViewHolder(binding, onItemSelectedListener)
    }

    override fun getItemCount(): Int = transferAccountList.size

    override fun onBindViewHolder(holder: TransferAccountViewHolder, position: Int) =
            holder.bindItem(transferAccountList[position])

    fun unSelectAllDistinctTo(transferAccount: TransferAccount) {
        transferAccountList
                .forEach {
                    if (!(transferAccount === it)) {
                        it.isSelected = false
                    }
                }
    }


    class TransferAccountViewHolder(private val binding: TransferRowBinding,
                                    private val onItemSelectedListener: OnItemSelected<TransferAccount>):RecyclerView.ViewHolder(binding.root) {

        fun bindItem(transferAccount: TransferAccount) = with(binding) {
            binding.root.setOnClickListener {
                onItemSelectedListener.onItemSelected(transferAccount)
            }
            if (transferAccount.isSelected) {
                binding.root.findViewById<CardView>(R.id.transferRowContainer)
                        .setCardBackgroundColor(ContextCompat.getColor(  binding.root.context, R.color.primary))
            } else {
                binding.root.findViewById<CardView>(R.id.transferRowContainer)
                        .setCardBackgroundColor(ContextCompat.getColor(  binding.root.context, R.color.divider))
            }
            Picasso
                    .get()
                    .load("https://media.licdn.com/dms/image/C4E03AQFcCuDIJl0mKg/profile-displayphoto-shrink_200_200/0?e=1583366400&v=beta&t=ymt3xgMe5bKS-2knNDL9mQYFksP9ZHne5ugIqEyRjZs")
                    .into(profilePhotoImageView)
        }
    }
}
