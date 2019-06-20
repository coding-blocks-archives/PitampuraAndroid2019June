package com.codingblocks.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_fragment_dc.view.dcLv


class FragmentDC : Fragment() {

    val dcMovies = arrayOf(
        "Man of Steel",
        "Shazam",
        "Sucide Squad",
        "Superman vs Batman",
        "Aquaman",
        "Wonder Woman"
    )
    val marvelMovies = arrayOf("Iron Man", "Captain America", "Thor", "Black Panther", "Avengers")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_dc, container, false)
        val argument = arguments
        if (argument?.getString("NAME") == "DC") {
            view.dcLv.adapter = ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                dcMovies
            )

        } else {
            view.dcLv.adapter = ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                marvelMovies
            )

        }
        return view
    }


}
