package com.jacob.thecatapi.presentation.catDetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jacob.thecatapi.R
import com.jacob.thecatapi.data.network.repositories.TheCatApiNetworkRepository
import com.jacob.thecatapi.databinding.FragmentCatDetailsBinding
import com.jacob.thecatapi.domain.useCases.GetCatApiUseCase
import com.jacob.thecatapi.presentation.catDetails.adapters.CatImagesAdapter
import com.jacob.thecatapi.presentation.catDetails.viewModel.CatDetailsViewModel
import com.jacob.thecatapi.presentation.catDetails.viewModel.CatDetailsViewModelFactory


class CatDetailsFragment : Fragment() {

    private var fragmentCatDetailsBinding: FragmentCatDetailsBinding? = null
    var image: String? = null
    var name: String? = null
    var origin: String? = null
    var country: String? = null
    var description: String? = null
    var characteristics: String? = null
    var affectiveLevel: Int = 0
    var adaptability: Int = 0
    var childFriendly: Int = 0
    var dogFriendly: Int = 0
    var energyLevel: Int = 0
    var images: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getString("image")
            name = it.getString("name")
            origin = it.getString("origin")
            country = it.getString("country")
            description = it.getString("description")
            characteristics = it.getString("characteristics")
            affectiveLevel = it.getInt("affectiveL")
            adaptability = it.getInt("adaptability")
            childFriendly = it.getInt("childFriendly")
            dogFriendly = it.getInt("dogFriendly")
            energyLevel = it.getInt("energyLevel")
            images = it.getString("images")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentCatDetailsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cat_details,
            container,
            false
        )
        fragmentCatDetailsBinding?.catDetailsViewModel =
            ViewModelProvider(
                this,
                CatDetailsViewModelFactory(
                    GetCatApiUseCase(
                        TheCatApiNetworkRepository()
                    )
                )
            ).get(CatDetailsViewModel::class.java)

        return fragmentCatDetailsBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentCatDetailsBinding?.catDetailsViewModel?.catImagesResponseMDL?.observe(
            viewLifecycleOwner, { catsApi ->
                if (catsApi.isNotEmpty()) {
                    fragmentCatDetailsBinding?.re?.apply {
                        layoutManager = LinearLayoutManager(context)
                        adapter = CatImagesAdapter(
                            catsApi,
                            this@CatDetailsFragment
                        )
                    }
                }
            }
        )

        getData()
    }

    private fun getData() {
        fragmentCatDetailsBinding?.imgDetails?.let {
            Glide
                .with(this)
                .load(image)
                .centerCrop()
                .into(it)
        }
        fragmentCatDetailsBinding?.btnOrigin?.text = origin
        fragmentCatDetailsBinding?.btnCountry?.text = country
        fragmentCatDetailsBinding?.txtDescripttionName?.text = name
        fragmentCatDetailsBinding?.txtDescripttion?.text = description
        fragmentCatDetailsBinding?.txtCharacteristics?.text = characteristics
        fragmentCatDetailsBinding?.affectiveRaiting?.rating = affectiveLevel.toFloat()
        fragmentCatDetailsBinding?.adaptabilityRaiting?.rating = adaptability.toFloat()
        fragmentCatDetailsBinding?.childFriendlyRaiting?.rating = childFriendly.toFloat()
        fragmentCatDetailsBinding?.dogFriendlyRaiting?.rating = dogFriendly.toFloat()
        fragmentCatDetailsBinding?.energyLevelRaiting?.rating = energyLevel.toFloat()
    }
}
