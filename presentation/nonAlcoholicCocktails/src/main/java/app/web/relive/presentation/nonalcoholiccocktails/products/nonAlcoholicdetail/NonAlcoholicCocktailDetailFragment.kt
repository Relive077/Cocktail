package app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicdetail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import app.web.relive.presentation.alcoholiccocktails.extension.load
import app.web.relive.presentation.nonalcoholiccocktails.R
import app.web.relive.presentation.alcoholiccocktails.extension.viewBinding
import app.web.relive.presentation.alcoholiccocktails.products.alcoholicCocktaildetail.AlcoholicCocktailDetailFragmentArgs
import app.web.relive.presentation.alcoholiccocktails.products.entity.AlcoholicDrinkUI
import app.web.relive.presentation.nonalcoholiccocktails.databinding.FragmentNonAlcoholicDetailBinding
import app.web.relive.presentation.nonalcoholiccocktails.products.entity.NonAlcoholicDrinkUI
import app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicList.NonAlcoholicCocktailListViewModel
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicCocktailDetailFragment : Fragment(R.layout.fragment_non_alcoholic_detail) {

    private val binding by viewBinding(FragmentNonAlcoholicDetailBinding::bind)

    private val productsDetailViewModel: NonAlcoholicCocktailDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()

        val safeArgs: NonAlcoholicCocktailDetailFragmentArgs by navArgs()
        val product = safeArgs.productDetailNonAlcoholicDrinkUI

        val nonAlcoholicDrinkUI = NonAlcoholicDrinkUI(
            product.id, product.name,product.imageUrl)

        binding.saveFab.setOnClickListener {
            productsDetailViewModel.saveNonAlcoholicDrink(nonAlcoholicDrinkUI)
        }

        productsDetailViewModel.getNonAlcoholicDrinkDetails(product.id)

        productsDetailViewModel.drinkDetails.observe(this, Observer {
            binding.productDetailInstTxv.text = it.strInstructions
            binding.productDetailTagsTxv.text = it.strTags
        })

    }

    private fun setupUI() {
        val safeArgs: NonAlcoholicCocktailDetailFragmentArgs by navArgs()
        val product = safeArgs.productDetailNonAlcoholicDrinkUI

        setSharedElementTransitionOnEnter()

        with(product) {
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