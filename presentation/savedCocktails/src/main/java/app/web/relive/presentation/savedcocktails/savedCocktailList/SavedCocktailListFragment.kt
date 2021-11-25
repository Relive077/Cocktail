package app.web.relive.presentation.savedcocktails.savedCocktailList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.web.relive.domain.base.Failure
import app.web.relive.presentation.alcoholiccocktails.base.adapter.LoadingStateAdapter
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.databinding.FragmentAlcoholicCocktailListBinding
import app.web.relive.presentation.alcoholiccocktails.extension.*
import app.web.relive.presentation.alcoholiccocktails.products.alcoholicCocktailList.AlcoholicCocktailListAdapter
import app.web.relive.presentation.nonalcoholiccocktails.databinding.FragmentNonAlcoholicListBinding
import app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicList.NonAlcoholicCocktailListAdapter
import app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicList.NonAlcoholicCocktailListViewModel
import app.web.relive.presentation.savedcocktails.R
import app.web.relive.presentation.savedcocktails.databinding.FragmentSavedCocktailListBinding
import com.google.android.material.transition.platform.Hold
import com.google.android.material.transition.platform.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedCocktailListFragment : Fragment(R.layout.fragment_saved_cocktail_list) {

    private val binding by viewBinding(FragmentSavedCocktailListBinding::bind) {
        cleanUp(it)
    }
    private val productsListViewModel: SavedCocktailListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productsListViewModel.savedAlcoholDrinks.observe(viewLifecycleOwner, Observer {
            binding.productListRecyclerView2.layoutManager = LinearLayoutManager(this.requireContext())
            binding.productListRecyclerView2.adapter = SavedAlcoholicCocktailListAdapter(it)
        })

        productsListViewModel.savedNonAlcoholDrinks.observe(viewLifecycleOwner, Observer {
            binding.productListRecyclerView.layoutManager = LinearLayoutManager(this.requireContext())
            binding.productListRecyclerView.adapter = SavedNonAlcoholicCocktailListAdapter(it)
        })





    }

    private fun cleanUp(binding: FragmentSavedCocktailListBinding?) {
        binding?.productListRecyclerView?.adapter = null
    }

}