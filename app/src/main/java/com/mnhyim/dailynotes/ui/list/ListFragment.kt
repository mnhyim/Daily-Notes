package com.mnhyim.dailynotes.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mnhyim.dailynotes.databinding.FragmentListBinding
import com.mnhyim.dailynotes.ui.home.HomeFragment
import com.mnhyim.dailynotes.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val TAG: String = ListFragment::class.java.simpleName
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val notesAdapter = ListAdapter()

        viewModel.notes.observe(viewLifecycleOwner) {
            notesAdapter.setNotes(it)
        }

        with(binding.rvListItem) {
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