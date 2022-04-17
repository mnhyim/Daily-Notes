package com.mnhyim.dailynotes.ui.calendar

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mnhyim.dailynotes.databinding.FragmentCalendarBinding
import com.mnhyim.dailynotes.ui.list.ListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CalendarViewModel by viewModel()
    private val TAG: String = CalendarFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val notesAdapter = ListAdapter()

        val sdf = SimpleDateFormat("dd-M-yyyy", Locale.getDefault())
        val date = (sdf.parse(sdf.format(Calendar.getInstance().time)) as Date).time
        Log.d(TAG, "${date}")
        viewModel.searchByDates(date)

        binding.calendarView.setOnDateChangeListener { _, i, i2, i3 ->
            val formatter = SimpleDateFormat("dd/M/yyyy", Locale.getDefault())
            val x = i2 + 1
            val date = formatter.parse("$i3/$x/$i").time
            Log.d(TAG, "1: $date")
            viewModel.searchByDates(date)
        }

        viewModel.notes.observe(viewLifecycleOwner) {
            Log.d(TAG, "observer fired:${viewModel.mutableDates.value} $it ")
            notesAdapter.setNotes(it)
        }

        with(binding.rvCalendarItem) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = notesAdapter
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}