package app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.web.relive.presentation.nonalcoholiccocktails.R
import app.web.relive.presentation.nonalcoholiccocktails.databinding.FragmentNonAlcoholicListBinding
import app.web.relive.presentation.nonalcoholiccocktails.extension.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicListFragment : Fragment(R.layout.fragment_non_alcoholic_list) {

    private val binding by viewBinding(FragmentNonAlcoholicListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGo.setOnClickListener {
            this.findNavController().navigate(NonAlcoholicListFragmentDirections.navigateToNonAlcoholicDetailFragment())
        }
    }

}