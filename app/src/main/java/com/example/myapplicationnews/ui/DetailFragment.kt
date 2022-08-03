package com.example.myapplicationnews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.myapplicationnews.MainViewModel
import com.example.myapplicationnews.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: MainViewModel by activityViewModels()
    private var newsId = 0
    private var newsStory = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            newsId = it.getInt("newsId")
            newsStory = it.getString("story").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.news.observe(
            viewLifecycleOwner,
            Observer { list ->
                val news = list.find { it.id == newsId }

                if (news != null) {
                    binding.detailImage.setImageResource(news.imageResourceId)
                    binding.detailTitle.text = news.title
                    binding.detailDatum.text = news.date
                    binding.detailText.text = news.story
                }
            }
        )
    }
}