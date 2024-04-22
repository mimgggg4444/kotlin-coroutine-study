package com.daelim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.home_bt1).setOnClickListener {
            buttonClicked(it)
        }
        view.findViewById<Button>(R.id.home_bt2).setOnClickListener {
            buttonClicked(it)
        }
        view.findViewById<Button>(R.id.home_bt3).setOnClickListener {
            buttonClicked(it)
        }
    }

    private fun buttonClicked(view: View) {
        if (view is Button) {
            (activity as? MainActivity)?.setButtonText(view.text.toString())
        }
    }
}
