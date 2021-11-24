package app.web.relive.data.products.local

import app.web.relive.data.products.entity.DrinkResponse
import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink

class DrinkResponseToDrinkDbMapper : Mapper<DrinkResponse, DrinkDb> {

    override fun mapLeftToRight(obj: DrinkResponse): DrinkDb = with(obj) {
        DrinkDb(
            strDrink = strDrink,
            strDrinkThumb = strDrinkThumb,
            idDrink = idDrink
        )
    }

}