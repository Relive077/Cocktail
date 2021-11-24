package app.web.relive.presentation.nonalcoholiccocktails.products.nonAlcoholicdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import app.web.relive.presentation.nonalcoholiccocktails.R
import app.web.relive.presentation.nonalcoholiccocktails.databinding.FragmentNonAlcoholicDetailBinding
import app.web.relive.presentation.nonalcoholiccocktails.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NonAlcoholicDetailFragment : Fragment(R.layout.fragment_non_alcoholic_detail) {

    private val binding by viewBinding(FragmentNonAlcoholicDetailBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}