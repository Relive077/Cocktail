package app.web.relive.presentation.alcoholiccocktails.local

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkUI

class AlcoholicDrinkUIToAlcoholicCocktailDbMapper : Mapper<AlcoholicDrinkUI, AlcoholicCocktailDb> {

    override fun mapLeftToRight(obj: AlcoholicDrinkUI): AlcoholicCocktailDb = with(obj) {
        AlcoholicCocktailDb(
            strDrink = name,
            strDrinkThumb = imageUrl,
            idDrink = id
        )
    }

}