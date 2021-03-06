package com.techand.daggerapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.techand.daggerapp.R
import com.techand.daggerapp.data.models.Image
import com.techand.daggerapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {


    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var item: Image

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item = args.item
        showDetail()
    }

    private fun showDetail() {
        binding.apply {
            imageView.load(item.path) {
                crossfade(true)
                crossfade(1000)
            }
            textView.text=item.desc
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}