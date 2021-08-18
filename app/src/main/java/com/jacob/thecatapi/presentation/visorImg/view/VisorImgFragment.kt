package com.jacob.thecatapi.presentation.visorImg.view

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.jacob.thecatapi.R
import com.jacob.thecatapi.databinding.FragmentVisorImgBinding
import com.jacob.thecatapi.presentation.visorImg.viewModel.VisorImgViewModel

class VisorImgFragment: Fragment() {

    private var fragmentVisorBiding: FragmentVisorImgBinding? = null
    var imagen : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imagen = it.getString("image")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentVisorBiding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_visor_img,
            container,
            false
        )
        fragmentVisorBiding?.visorImgViewModel =
            ViewModelProvider(
                this
            ).get(VisorImgViewModel::class.java)

        return fragmentVisorBiding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}