package com.cheise_proj.spiice_ui_challenge.onBoarding.ui.starter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cheise_proj.spiice_ui_challenge.R
import kotlinx.android.synthetic.main.fragment_starter.*

/**
 * A simple [Fragment] subclass.
 */
class StarterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_starter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_footer.setOnClickListener {
            val action = StarterFragmentDirections.actionStarterFragmentToSignInFragment()
            findNavController().navigate(action)
        }
        btn_discover.setOnClickListener {
            val action = StarterFragmentDirections.actionStarterFragmentToOnBoardingFragment()
            findNavController().navigate(action)
        }
    }

}
