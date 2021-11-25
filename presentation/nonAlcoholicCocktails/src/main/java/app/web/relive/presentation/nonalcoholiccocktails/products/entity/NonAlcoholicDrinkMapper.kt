package app.web.relive.presentation.nonalcoholiccocktails.products.entity

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink

class NonAlcoholicDrinkMapper : Mapper<Drink, NonAlcoholicDrinkUI> {

    override fun mapLeftToRight(obj: Drink): NonAlcoholicDrinkUI = with(obj) {
        NonAlcoholicDrinkUI(
            id = idDrink,
            name = strDrink,
            imageUrl = strDrinkThumb
        )
    }

}