package app.web.relive.presentation.savedcocktails.savedCocktailDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import app.web.relive.presentation.alcoholiccocktails.extension.viewBinding
import app.web.relive.presentation.savedcocktails.R
import app.web.relive.presentation.savedcocktails.databinding.FragmentSavedCocktailDetailBinding
import app.web.relive.presentation.savedcocktails.databinding.FragmentSavedCocktailListBinding
import app.web.relive.presentation.savedcocktails.savedCocktailList.SavedCocktailListFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedCocktailDetailFragment : Fragment(R.layout.fragment_saved_cocktail_detail) {

    private val binding by viewBinding(FragmentSavedCocktailDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}