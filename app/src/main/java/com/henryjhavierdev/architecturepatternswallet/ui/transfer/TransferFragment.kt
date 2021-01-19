package com.henryjhavierdev.architecturepatternswallet.ui.transfer

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.henryjhavierdev.architecturepatternswallet.R
import com.henryjhavierdev.architecturepatternswallet.databinding.FragmentTransferBinding
import com.henryjhavierdev.architecturepatternswallet.helpers.OnItemSelected
import com.henryjhavierdev.architecturepatternswallet.model.TransferAccount
import java.text.NumberFormat

class TransferFragment : Fragment() {

    private val DOLLAR_SYMBOL = "\$ "
    private val CLEAN_STRING_REGEX_PATTERN = "[\$,.\\s]".toRegex()
    private var current = ""
    private var selectedTransferAccount: TransferAccount? = null
    private lateinit var binding: FragmentTransferBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding   = FragmentTransferBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAmountInputEditText()
        initRecyclerView()
    }


    private fun initRecyclerView() {
        binding.transferAccountsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.transferAccountsRecyclerView.adapter = transferAccountsAdapter
        val transferAccount = TransferAccount.Builder("12345")
                .setProfilePhotoUrl("htttps://www.google.com/imagenDePrueba")
                .setUserName("Paquito Perez")
                .build()
        val transferAccountList = listOf(transferAccount)
        /*val transferAccountList = listOf(
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","",""),
            TransferAccount("", "", "", "", false,"","","","","")
        )*/
        transferAccountsAdapter.setTransferAccountList(transferAccountList)
    }

    private fun initAmountInputEditText() {
        binding.amountValueInputEditText.onFocusChangeListener =
                View.OnFocusChangeListener { _, hasFocus ->
                    if (hasFocus && binding.amountValueInputEditText.text.toString().isBlank()) {
                        binding.amountValueInputEditText.setText(DOLLAR_SYMBOL)
                    }
                }
        binding.amountValueInputEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s.toString().let { text ->
                    if (!text.isBlank() && text != current) {
                        binding.amountValueInputEditText.removeTextChangedListener(this)
                        val cleanString = text.replace(CLEAN_STRING_REGEX_PATTERN, "")
                        if (cleanString.isBlank()) {
                            binding.amountValueInputEditText.setText(DOLLAR_SYMBOL)
                            binding.amountValueInputEditText.addTextChangedListener(this)
                            binding.amountValueInputEditText.setSelection(binding.amountValueInputEditText.text.toString().length)
                        } else {
                            val parsed = cleanString.toDouble()
                            val formatted = NumberFormat.getCurrencyInstance().format((parsed))
                            current = formatted
                            binding.amountValueInputEditText.setText(formatted)
                            binding.amountValueInputEditText.setSelection(formatted.length)
                            binding.amountValueInputEditText.addTextChangedListener(this)
                        }

                    }
                }
            }
        })
    }

    private val onItemSelectedListener: OnItemSelected<TransferAccount> =
            object : OnItemSelected<TransferAccount> {
                override fun onItemSelected(item: TransferAccount) {
                    selectedTransferAccount = item
                    item.isSelected = true
                    transferAccountsAdapter.unSelectAllDistinctTo(item)
                    transferAccountsAdapter.notifyDataSetChanged()
                    binding.transferButton.isEnabled = true
                }
            }
    private val transferAccountsAdapter = TransferAccountsAdapter(onItemSelectedListener)



}