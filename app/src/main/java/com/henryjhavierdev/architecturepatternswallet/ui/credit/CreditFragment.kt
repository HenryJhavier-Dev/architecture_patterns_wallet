package com.henryjhavierdev.architecturepatternswallet.ui.credit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.recyclerview.widget.LinearLayoutManager
import com.henryjhavierdev.architecturepatternswallet.R
import com.henryjhavierdev.architecturepatternswallet.databinding.FragmentCreditBinding
import com.henryjhavierdev.architecturepatternswallet.databinding.FragmentHomeBinding
import com.henryjhavierdev.architecturepatternswallet.model.Loan

class CreditFragment : Fragment() {

    private val adapter = CreditAdapter()
    private lateinit var binding: FragmentCreditBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreditBinding.inflate(layoutInflater)

        binding.apply {

            val loansList = listOf(
                    Loan("", 50.toDouble(), 500.toDouble(), ""),
                    Loan("", 50.toDouble(), 500.toDouble(), "")
            )
            loansRecyclerView.adapter = adapter
            loansRecyclerView.layoutManager = LinearLayoutManager(context)
            adapter.setData(loansList)

            circularProgress.setProgressWithAnimation(
                    70f,
                    1000,
                    AccelerateDecelerateInterpolator(),
                    300
            )
        }

        return binding.root
    }


}