package com.daelim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.daelim.R

class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.my_btn1).setOnClickListener {
            buttonClicked(it)
        }
        // home_bt2가 MyFragment에도 있다고 가정합니다.
        view.findViewById<Button>(R.id.home_bt2).setOnClickListener {
            buttonClicked(it)
        }
    }

    private fun buttonClicked(view: View) {
        if (view is Button) {
            (activity as? MainActivity)?.setButtonText(view.text.toString())
        }
    }
}
