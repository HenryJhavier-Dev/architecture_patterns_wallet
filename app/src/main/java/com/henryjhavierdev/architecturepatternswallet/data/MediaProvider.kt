package com.henryjhavierdev.architecturepatternswallet.data

import androidx.annotation.WorkerThread
import com.henryjhavierdev.architecturepatternswallet.model.FavoriteTransfer

@WorkerThread
object MediaProvider {
    fun loadFavoriteTransfer(): ArrayList<FavoriteTransfer>{
        Thread.sleep(2000)
        return arrayListOf(
            FavoriteTransfer(1,"Rick Sanchez", 243.000, "Hace 3h", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            FavoriteTransfer(2,"Morty Smith", 432.000, "Ayer", "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
            FavoriteTransfer(3,"Summer Smith", 456.000, "Hace 12h","https://rickandmortyapi.com/api/character/avatar/3.jpeg"),
            FavoriteTransfer(4,"Beth Smith", 654.000, "Hace 30m", "https://rickandmortyapi.com/api/character/avatar/4.jpeg"),
            FavoriteTransfer(5,"Jerry Smith", 789.000, "Más de 30D", "https://rickandmortyapi.com/api/character/avatar/5.jpeg"),
            FavoriteTransfer(6,"Abadango Cluster Princess", 980.000 ,"Ayer","https://rickandmortyapi.com/api/character/avatar/6.jpeg"),
            FavoriteTransfer(7,"Abradolf Lincler", 12.000, "Ayer","https://rickandmortyapi.com/api/character/avatar/7.jpeg"),
            FavoriteTransfer(8,"Adjudicator Rick", 606.000, "Ayer", "https://rickandmortyapi.com/api/character/avatar/8.jpeg")
        )

    }
}
