package app.web.relive.presentation.savedcocktails.savedCocktailList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.RecyclerView
import app.web.relive.domain.base.Failure
import app.web.relive.presentation.alcoholiccocktails.base.adapter.LoadingStateAdapter
import app.web.relive.presentation.alcoholiccocktails.base.adapter.RecyclerItem
import app.web.relive.presentation.alcoholiccocktails.extension.*
import app.web.relive.presentation.savedcocktails.R
import app.web.relive.presentation.savedcocktails.databinding.FragmentSavedCocktailListBinding
import com.google.android.material.transition.platform.Hold
import com.google.android.material.transition.platform.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedCocktailListFragment : Fragment(R.layout.fragment_saved_cocktail_list) {

    private val binding by viewBinding(FragmentSavedCocktailListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGo.setOnClickListener {
            this.findNavController().navigate(SavedCocktailListFragmentDirections.navigateToSavedCocktailDetailFragment())
        }
    }

}