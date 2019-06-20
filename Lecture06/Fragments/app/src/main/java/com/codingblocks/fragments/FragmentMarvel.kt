package com.codingblocks.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_fragment_marvel.view.marvelLv


class FragmentMarvel : Fragment() {

    val marvelMovies = arrayOf("Iron Man","Captain America","Thor","Black Panther","Avengers")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_marvel, container, false)
        view.marvelLv.adapter = ArrayAdapter<String>(requireContext(),R.layout.simple_list_item_1,marvelMovies)

        return view
    }


}
