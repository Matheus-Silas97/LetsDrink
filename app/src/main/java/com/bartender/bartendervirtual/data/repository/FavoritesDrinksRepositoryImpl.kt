package com.bartender.bartendervirtual.data.repository

import com.bartender.bartendervirtual.data.datasource.FavoritesDrinksLocalDataSource
import com.bartender.bartendervirtual.domain.model.DrinkDetails
import com.bartender.bartendervirtual.domain.model.DrinkFavorite
import com.bartender.bartendervirtual.domain.repository.FavoritesDrinksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoritesDrinksRepositoryImpl(private val favoritesDrinksLocalDataSource: FavoritesDrinksLocalDataSource) :
    FavoritesDrinksRepository {

    override suspend fun allDrinks(): Flow<List<DrinkFavorite>> = flow {
        emit(favoritesDrinksLocalDataSource.allDrinks())
    }

    override suspend fun drinkDetails(drinkId: Long): Flow<DrinkDetails> = flow {
        emit(favoritesDrinksLocalDataSource.drinkDetails(drinkId = drinkId))
    }

    override suspend fun insertDrink(drinkFavorite: DrinkDetails): Flow<Long> = flow {
        emit(favoritesDrinksLocalDataSource.addDrinks(drink = drinkFavorite))
    }

    override suspend fun deleteDrink(drinkId: Long): Flow<Int> = flow {
        emit(favoritesDrinksLocalDataSource.deleteDrink(drinkId = drinkId))
    }

    override suspend fun isFavorite(drinkId: Long): Flow<Boolean> = flow {
        emit(favoritesDrinksLocalDataSource.isFavorite(drinkId = drinkId))
    }
}