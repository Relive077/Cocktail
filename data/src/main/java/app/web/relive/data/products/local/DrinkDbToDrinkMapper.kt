package app.web.relive.data.products.local

import app.web.relive.data.products.entity.DrinkResponse
import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink

class DrinkDbToDrinkMapper : Mapper<DrinkDb, Drink> {

    override fun mapLeftToRight(obj: DrinkDb): Drink = with(obj) {
        Drink(
            strDrink = strDrink,
            strDrinkThumb = strDrinkThumb,
            idDrink = idDrink
        )
    }

}