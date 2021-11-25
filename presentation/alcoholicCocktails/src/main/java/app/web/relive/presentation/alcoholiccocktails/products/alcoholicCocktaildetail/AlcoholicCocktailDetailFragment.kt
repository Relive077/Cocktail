package app.web.relive.presentation.alcoholiccocktails.products.alcoholicCocktaildetail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import app.web.relive.presentation.alcoholiccocktails.R
import app.web.relive.presentation.alcoholiccocktails.databinding.FragmentAlcoholicCocktailDetailBinding
import app.web.relive.presentation.alcoholiccocktails.extension.load

import app.web.relive.presentation.alcoholiccocktails.extension.viewBinding
import app.web.relive.presentation.alcoholiccocktails.products.alcoholicCocktailList.AlcoholicCocktailListViewModel
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkUI
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlcoholicCocktailDetailFragment : Fragment(R.layout.fragment_alcoholic_cocktail_detail) {

    private val binding by viewBinding(FragmentAlcoholicCocktailDetailBinding::bind)

    private val productsListViewModel: AlcoholicCocktailListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        val safeArgs: AlcoholicCocktailDetailFragmentArgs by navArgs()
        val product = safeArgs.productDetailDrinkUI

        val alcoholicDrinkUI = AlcoholicDrinkUI(
            product.id, product.name,product.imageUrl)

        binding.saveFab.setOnClickListener {
            productsListViewModel.saveAlcoholicDrink(alcoholicDrinkUI)
        }
    }

    private fun setupUI() {
        val safeArgs: AlcoholicCocktailDetailFragmentArgs by navArgs()
        val product = safeArgs.productDetailDrinkUI

        setSharedElementTransitionOnEnter()

        with(product) {
            binding.productDetailIdTxv.text = id.toString()
            binding.productDetailContainer.transitionName = id.toString()
            binding.productDetailImv.load(url = imageUrl, activity = activity)
            binding.productDetailNameTxv.text = name
        }
    }

    private fun setSharedElementTransitionOnEnter() {
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 400L
            isElevationShadowEnabled = true
            pathMotion = MaterialArcMotion()
            startElevation = 9f
            endElevation = 9f
            scrimColor = Color.TRANSPARENT
        }
    }

}