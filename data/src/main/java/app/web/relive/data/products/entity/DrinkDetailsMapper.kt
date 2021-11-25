package app.web.relive.data.products.entity

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.domain.products.entity.Drink
import app.web.relive.domain.products.entity.DrinkDetails

class DrinkDetailsMapper : Mapper<DrinkDetailsResponse, DrinkDetails> {

    override fun mapLeftToRight(obj: DrinkDetailsResponse): DrinkDetails = with(obj) {
        DrinkDetails(
            strInstructions = strInstructions,
            strTags = strTags
        )
    }

}