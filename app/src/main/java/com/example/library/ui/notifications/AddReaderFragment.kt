package com.example.library.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.library.R

class AddReaderFragment : Fragment() {

    private lateinit var addReaderViewModel: AddReaderViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addReaderViewModel =
                ViewModelProvider(this).get(AddReaderViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_reader, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        addReaderViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}