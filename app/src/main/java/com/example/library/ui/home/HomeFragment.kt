package com.example.library.ui.home

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.library.R
import com.example.library.dao
import com.example.library.db
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*
import kotlin.time.days

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.number)
        val calendarView = root.findViewById<CalendarView>(R.id.calendar)
        val saveButton = root.findViewById<Button>(R.id.save_button)
        val plus = root.findViewById<ImageView>(R.id.plus)
        val minus = root.findViewById<ImageView>(R.id.minus)
        homeViewModel.number.observe(viewLifecycleOwner, Observer {
            textView.text = it.toString()
        })
        var key = "${Date().year}${Date().month}${Date().day}"
        homeViewModel.set(key.toInt())
        calendarView.setOnDateChangeListener { view, year: Int, month: Int, day: Int ->
            key = year.toString() + month.toString() + day.toString()
            try {
                homeViewModel.set(key.toInt())
            } catch (
                e: Exception
            ) {
            }
        }
        plus.setOnClickListener {
            homeViewModel.plus()
            homeViewModel.saveData(key.toInt(), homeViewModel.number.value.toString())
        }
        minus.setOnClickListener {
            homeViewModel.minus()
            homeViewModel.saveData(key.toInt(), homeViewModel.number.value.toString())
        }
        saveButton.setOnClickListener { view ->
            homeViewModel.saveData(key.toInt(), homeViewModel.number.value.toString())
        }
        homeViewModel.getData()
        return root

    }
}