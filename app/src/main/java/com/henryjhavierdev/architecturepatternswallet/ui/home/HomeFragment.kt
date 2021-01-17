package com.henryjhavierdev.architecturepatternswallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.henryjhavierdev.architecturepatternswallet.databinding.FragmentHomeBinding
import com.henryjhavierdev.architecturepatternswallet.helpers.Constant
import com.henryjhavierdev.architecturepatternswallet.helpers.loadImageViewFromUrl
import com.henryjhavierdev.architecturepatternswallet.model.FavoriteTransfer
import com.henryjhavierdev.architecturepatternswallet.model.HomeContract
import com.henryjhavierdev.architecturepatternswallet.presenter.HomePresenter
import com.squareup.picasso.Picasso

class HomeFragment : Fragment(), HomeContract.View {

    private lateinit var binding: FragmentHomeBinding
    private var homePresenter:HomeContract.Presenter? = null
    private val favoriteTransferAdapter = FavoriteTransferAdapter()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        homePresenter = HomePresenter(this)
        homePresenter?.retrieveFavoriteTransfers()


        binding.apply {

            favoriteTransfersRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

            favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter

            circularProgress.setProgressWithAnimation(
                90f,
                1000,
                AccelerateDecelerateInterpolator(),
                500
            )

            //Using an extension function
            profilePhotoImageView.loadImageViewFromUrl(Constant.urlImage)

        }

        return binding.root

    }

    override fun showLoader() {
        binding.pgbHomeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        binding.pgbHomeLoader.visibility = View.GONE
    }

    override fun showFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfer);
    }

}