package com.example.library.ui.formular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.library.R

class FormularFragment : Fragment() {

    private lateinit var formularViewModel: FormularViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        formularViewModel =
                ViewModelProvider(this).get(FormularViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_formular, container, false)
        formularViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }
}