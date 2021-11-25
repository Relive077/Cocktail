package app.web.relive.presentation.nonalcoholiccocktails.products.local

import app.web.relive.domain.base.mapper.Mapper
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDb
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDb
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkUI
import app.web.relive.presentation.nonalcoholiccocktails.products.entity.NonAlcoholicDrinkUI

class NonAlcoholicDrinkUIToNonAlcoholicCocktailDbMapper : Mapper<NonAlcoholicDrinkUI, NonAlcoholicCocktailDb> {

    override fun mapLeftToRight(obj: NonAlcoholicDrinkUI): NonAlcoholicCocktailDb = with(obj) {
        NonAlcoholicCocktailDb(
            strDrink = name,
            strDrinkThumb = imageUrl,
            idDrink = id
        )
    }

}