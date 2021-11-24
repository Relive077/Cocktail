package app.web.relive.data.products.entity

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink

class DrinkMapper : Mapper<DrinkResponse, Drink> {

    override fun mapLeftToRight(obj: DrinkResponse): Drink = with(obj) {
        Drink(
            strDrink = strDrink,
            strDrinkThumb = strDrinkThumb,
            idDrink = idDrink
        )
    }

}