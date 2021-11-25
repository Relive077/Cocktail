package app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicdetail

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import app.web.relive.presentation.alcoholiccocktails.extension.load
import app.web.relive.presentation.nonalcoholiccocktails.R
import app.web.relive.presentation.alcoholiccocktails.extension.viewBinding
import app.web.relive.presentation.nonalcoholiccocktails.databinding.FragmentNonAlcoholicDetailBinding
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicCocktailDetailFragment : Fragment(R.layout.fragment_non_alcoholic_detail) {

    private val binding by viewBinding(FragmentNonAlcoholicDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        val safeArgs: NonAlcoholicCocktailDetailFragmentArgs by navArgs()
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