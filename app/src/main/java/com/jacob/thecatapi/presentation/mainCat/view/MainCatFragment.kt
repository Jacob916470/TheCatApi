package com.jacob.thecatapi.presentation.mainCat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jacob.thecatapi.R
import com.jacob.thecatapi.data.network.models.TheCatApiResponseItem
import com.jacob.thecatapi.data.network.repositories.TheCatApiNetworkRepository
import com.jacob.thecatapi.databinding.FragmentMainCatBinding
import com.jacob.thecatapi.domain.useCases.GetCatApiUseCase
import com.jacob.thecatapi.presentation.core.callBack.OnItemClickListener
import com.jacob.thecatapi.presentation.mainCat.adapters.TheCatApiAdapter
import com.jacob.thecatapi.presentation.mainCat.viewModel.MainCatViewModel
import com.jacob.thecatapi.presentation.mainCat.viewModel.MainCatViewModelFactory

class MainCatFragment : Fragment(), OnItemClickListener<TheCatApiResponseItem> {

    private var fragmentMainCatBinding: FragmentMainCatBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMainCatBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_main_cat,
            container,
            false
        )

        fragmentMainCatBinding?.mainCatViewModel =
            ViewModelProvider(
                this,
                MainCatViewModelFactory(
                    GetCatApiUseCase(
                        TheCatApiNetworkRepository()
                    )
                )
            ).get(MainCatViewModel::class.java)

        return fragmentMainCatBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMainCatBinding?.mainCatViewModel?.catsApiResponseMDL?.observe(
            viewLifecycleOwner, { catsApi ->
                if (catsApi.isNotEmpty()) {
                    fragmentMainCatBinding?.recyclerMain?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = TheCatApiAdapter(catsApi, this@MainCatFragment)
                    }
                }
            }
        )
    }

    override fun onItemClick(item: TheCatApiResponseItem, type: String?) {
        val bundle = bundleOf(
            "image" to item.image?.url,
            "name" to item.name,
            "origin" to item.origin,
            "country" to item.country_codes,
            "description" to item.description,
            "characteristics" to item.temperament,
            "affectiveL" to item.affection_level,
            "adaptability" to item.adaptability,
            "childFriendly" to item.child_friendly,
            "dogFriendly" to item.dog_friendly,
            "energyLevel" to item.energy_level,
        )
        findNavController().navigate(R.id.action_mainCatFragment_to_catDetailsFragment, bundle)
    }
}