package com.bartender.bartendervirtual.presentation.drink_details

sealed class DrinkDetailsInteraction {

    object NavigationClickBackPressed : DrinkDetailsInteraction()

    object CloseErrorDialog : DrinkDetailsInteraction()

    data class FavoriteDrink(val drinkId: Long) : DrinkDetailsInteraction()

    data class CardClickInteraction(val drinkId: Long) : DrinkDetailsInteraction()

}