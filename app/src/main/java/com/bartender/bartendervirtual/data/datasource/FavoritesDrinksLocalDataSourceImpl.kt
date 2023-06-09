package com.bartender.bartendervirtual.data.datasource

import com.bartender.bartendervirtual.data.local.AppDatabase
import com.bartender.bartendervirtual.data.mapper.convertDrinkDetails
import com.bartender.bartendervirtual.data.mapper.convertFavorite
import com.bartender.bartendervirtual.data.mapper.convertToDrinkFavoriteEntity
import com.bartender.bartendervirtual.domain.model.DrinkDetails
import com.bartender.bartendervirtual.domain.model.DrinkFavorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoritesDrinksLocalDataSourceImpl(
    private val appDatabase: AppDatabase
) : FavoritesDrinksLocalDataSource {

    override suspend fun allDrinks(): List<DrinkFavorite> = withContext(Dispatchers.IO) {
        return@withContext appDatabase.favorites().getAll().convertFavorite()
    }

    override suspend fun drinkDetails(drinkId: Long): DrinkDetails = withContext(Dispatchers.IO) {
        return@withContext appDatabase.favorites().loadDrink(id = drinkId).convertDrinkDetails()
    }

    override suspend fun addDrinks(drink: DrinkDetails): Long = withContext(Dispatchers.IO) {
        return@withContext appDatabase.favorites()
            .insert(drink = drink.convertToDrinkFavoriteEntity())
    }

    override suspend fun deleteDrink(drinkId: Long): Int = withContext(Dispatchers.IO) {
        return@withContext appDatabase.favorites()
            .deleteTraining(drinkId = drinkId)
    }

    override suspend fun isFavorite(drinkId: Long): Boolean = withContext(Dispatchers.IO) {
        return@withContext appDatabase.favorites().isFavorite(drinkId = drinkId)
    }

}