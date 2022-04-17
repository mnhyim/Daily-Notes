package com.mnhyim.dailynotes.ui.home

import android.app.ProgressDialog.show
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mnhyim.core.domain.model.Note
import com.mnhyim.dailynotes.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private val TAG: String = HomeFragment::class.java.simpleName
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.fabAddNote.setOnClickListener {
            Toast.makeText(context, "TESTT", Toast.LENGTH_LONG).show()
            AddNoteDialog().show(parentFragmentManager, "TEST")
        }

        viewModel.totalNotes.observe(viewLifecycleOwner) {
            binding.tvTotalNotes.text = it.toString()
        }

        viewModel.upcomingNotes.observe(viewLifecycleOwner) {
            binding.tvUpcomingNotes.text = it.toString()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}