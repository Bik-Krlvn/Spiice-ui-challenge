package com.cheise_proj.spiice_ui_challenge.spiice.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cheise_proj.spiice_ui_challenge.R

/**
 * A simple [Fragment] subclass.
 */
class FeedDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed_detail, container, false)
    }

}
