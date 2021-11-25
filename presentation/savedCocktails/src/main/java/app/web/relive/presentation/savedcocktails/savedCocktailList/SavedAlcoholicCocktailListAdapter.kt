package app.web.relive.presentation.savedcocktails.savedCocktailList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import app.web.relive.presentation.alcoholiccocktails.extension.load
import app.web.relive.presentation.alcoholiccocktails.local.AlcoholicCocktailDb
import app.web.relive.presentation.savedcocktails.R

class SavedAlcoholicCocktailListAdapter(private val mList: List<AlcoholicCocktailDb>) : RecyclerView.Adapter<SavedAlcoholicCocktailListAdapter.SavedAlcoholicCocktailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedAlcoholicCocktailViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saved_product, parent, false)

        return SavedAlcoholicCocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedAlcoholicCocktailViewHolder, position: Int) {

        val savedAlcoholicCocktail = mList[position]
        holder.drinkImage.load(savedAlcoholicCocktail.strDrinkThumb)
        holder.drinkName.text = savedAlcoholicCocktail.strDrink
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class SavedAlcoholicCocktailViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val drinkImage: ImageView = itemView.findViewById(R.id.itemProductImv)
        val drinkName: TextView = itemView.findViewById(R.id.itemProductNameTxv)
    }
}