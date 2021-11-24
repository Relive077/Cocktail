package app.web.relive.presentation.products.entity

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink

class DrinkUIMapper : Mapper<Drink, DrinkUI> {

    override fun mapLeftToRight(obj: Drink): DrinkUI = with(obj) {
        DrinkUI(
            strDrink = strDrink,
            strDrinkThumb = strDrinkThumb,
            idDrink = idDrink
        )
    }

}