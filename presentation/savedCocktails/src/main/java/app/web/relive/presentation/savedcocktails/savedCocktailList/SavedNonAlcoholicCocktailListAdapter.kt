package app.web.relive.presentation.savedcocktails.savedCocktailList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.web.relive.presentation.alcoholiccocktails.extension.load
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDb
import app.web.relive.presentation.alcoholiccocktails.local.NonAlcoholicCocktailDb
import app.web.relive.presentation.savedcocktails.R

class SavedNonAlcoholicCocktailListAdapter(private val mList: List<NonAlcoholicCocktailDb>) : RecyclerView.Adapter<SavedNonAlcoholicCocktailListAdapter.SavedNonAlcoholicCocktailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedNonAlcoholicCocktailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved_product, parent, false)

        return SavedNonAlcoholicCocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedNonAlcoholicCocktailViewHolder, position: Int) {

        val savedNonAlcoholicCocktail = mList[position]
        holder.drinkImage.load(savedNonAlcoholicCocktail.strDrinkThumb)
        holder.drinkName.text = savedNonAlcoholicCocktail.strDrink
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class SavedNonAlcoholicCocktailViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val drinkImage: ImageView = itemView.findViewById(R.id.itemProductImv)
        val drinkName: TextView = itemView.findViewById(R.id.itemProductNameTxv)
    }
}