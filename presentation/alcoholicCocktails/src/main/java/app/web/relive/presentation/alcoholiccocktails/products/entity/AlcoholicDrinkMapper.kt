package app.web.relive.presentation.alcoholiccocktails.products.entity

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink

class AlcoholicDrinkMapper : Mapper<Drink, AlcoholicDrinkUI> {

    override fun mapLeftToRight(obj: Drink): AlcoholicDrinkUI = with(obj) {
        AlcoholicDrinkUI(
            id = idDrink,
            name = strDrink,
            imageUrl = strDrinkThumb
        )
    }

}