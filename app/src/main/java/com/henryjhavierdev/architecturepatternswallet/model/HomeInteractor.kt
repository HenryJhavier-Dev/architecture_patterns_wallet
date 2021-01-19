package com.henryjhavierdev.architecturepatternswallet.model

import com.henryjhavierdev.architecturepatternswallet.data.MediaProvider
import java.util.logging.Handler

class HomeInteractor {

    fun retrieveFavoriteTransferFromCache(responseCallback: HomeContract.OnResponseCallback){
        responseCallback.onResponse(MediaProvider.loadFavoriteTransfer())
    }


}