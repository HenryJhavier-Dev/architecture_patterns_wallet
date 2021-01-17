package com.henryjhavierdev.architecturepatternswallet.presenter

import com.henryjhavierdev.architecturepatternswallet.model.FavoriteTransfer
import com.henryjhavierdev.architecturepatternswallet.model.HomeContract
import com.henryjhavierdev.architecturepatternswallet.model.HomeInteractor

class HomePresenter(private val view:HomeContract.View) : HomeContract.Presenter  {

    private val homeInteractor = HomeInteractor()

    override fun retrieveFavoriteTransfers() {
        view.showLoader()
        homeInteractor.retrieveFavoriteTransferFromCache(object: HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {

                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }

}