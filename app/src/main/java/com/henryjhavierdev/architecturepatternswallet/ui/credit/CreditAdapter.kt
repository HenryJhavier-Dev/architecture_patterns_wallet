package com.henryjhavierdev.architecturepatternswallet.ui.credit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henryjhavierdev.architecturepatternswallet.databinding.FavoriteTransferRowBinding
import com.henryjhavierdev.architecturepatternswallet.databinding.LoanRowBinding
import com.henryjhavierdev.architecturepatternswallet.helpers.loadImageViewFromUrl
import com.henryjhavierdev.architecturepatternswallet.model.FavoriteTransfer
import com.henryjhavierdev.architecturepatternswallet.model.Loan
import com.henryjhavierdev.architecturepatternswallet.ui.home.FavoriteTransferAdapter
import com.squareup.picasso.Picasso

class CreditAdapter: RecyclerView.Adapter<CreditAdapter.CreditViewHolder>() {


    private var loansList = emptyList<Loan>()

    fun setData(dataList: List<Loan>) {
        loansList = dataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditViewHolder {
        val binding =  LoanRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreditViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreditViewHolder, position: Int) {
        holder.bindItem(loansList[position])
    }

    override fun getItemCount(): Int = loansList.size

    class CreditViewHolder(private val binding:LoanRowBinding ):RecyclerView.ViewHolder(binding.root) {

        fun bindItem(item: Loan) = with(binding){

            com.squareup.picasso.Picasso
                    .get()
                    .load("https://tickera-wpsalad.netdna-ssl.com/wp-content/themes/tickera/style/img/freebies/icons/events/24.png")
                    .into(loanImageView)
        }
    }
}



