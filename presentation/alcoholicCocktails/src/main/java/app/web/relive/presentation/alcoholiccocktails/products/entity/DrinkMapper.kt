package app.web.relive.presentation.alcoholiccocktails.products.entity

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink

class DrinkMapper : Mapper<Drink, DrinkUI> {

    override fun mapLeftToRight(obj: Drink): DrinkUI = with(obj) {
        DrinkUI(
            id = idDrink,
            name = strDrink,
            imageUrl = strDrinkThumb
        )
    }

}